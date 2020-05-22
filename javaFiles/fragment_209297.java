import java.lang.reflect.Type;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.annotation.Annotation;

import java.util.Set;
import java.util.HashSet;
import java.util.Collections;

import javax.ws.rs.FormParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.ext.ParamConverter;
import javax.ws.rs.ext.ParamConverterProvider;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.InternalServerErrorException;

@Provider
public class Base32UUIDParamConverter implements ParamConverterProvider {

    @Context
    private javax.inject.Provider<ResourceInfo> resourceInfo;

    private static final Set<Class<? extends Annotation>> ANNOTATIONS;

    static {
        Set<Class<? extends Annotation>> annots = new HashSet<>();
        annots.add(QueryParam.class);
        annots.add(FormParam.class);
        ANNOTATIONS = Collections.<Class<? extends Annotation>>unmodifiableSet(annots);
    }

    @Override
    public <T> ParamConverter<T> getConverter(Class<T> type, 
                                              Type type1,
                                              Annotation[] annots) {

        // Check if it is @FormParam or @QueryParam
        for (Annotation annotation : annots) {
            if (!ANNOTATIONS.contains(annotation.annotationType())) {
                return null;
            }
        }

        if (Base32UUID.class == type) {
            return new ParamConverter<T>() {

                @Override
                public T fromString(String value) {
                    try {
                        Method method = resourceInfo.get().getResourceMethod();

                        Parameter[] parameters = method.getParameters();
                        Parameter actualParam = null;

                        // Find the actual matching parameter from the method.
                        for (Parameter param : parameters) {
                            Annotation[] annotations = param.getAnnotations();
                            if (matchingAnnotationValues(annotations, annots)) {
                                actualParam = param;
                            }
                        }

                        // null warning, but assuming my logic is correct, 
                        // null shouldn't be possible. Maybe check anyway :-)
                        String paramName = actualParam.getName();
                        System.out.println("Param name : " + paramName);

                        Base32UUID uuid = new Base32UUID(value, paramName);
                        return type.cast(uuid);
                    } catch (Base32UUIDException ex) {
                        throw new BadRequestException(ex.getMessage());
                    } catch (Exception ex) {
                        throw new InternalServerErrorException(ex);
                    }
                }

                @Override
                public String toString(T t) {
                    return ((Base32UUID) t).value;
                }
            };
        }

        return null;
    }

    private boolean matchingAnnotationValues(Annotation[] annots1, 
                                             Annotation[] annots2) throws Exception {

        for (Class<? extends Annotation> annotType : ANNOTATIONS) {
            if (isMatch(annots1, annots2, annotType)) {
                return true;
            }
        }
        return false;
    }

    private <T extends Annotation> boolean isMatch(Annotation[] a1, 
                                                   Annotation[] a2, 
                                                   Class<T> aType) throws Exception {
        T p1 = getParamAnnotation(a1, aType);
        T p2 = getParamAnnotation(a2, aType);
        if (p1 != null && p2 != null) {
            String value1 = (String) p1.annotationType().getMethod("value").invoke(p1);
            String value2 = (String) p2.annotationType().getMethod("value").invoke(p2);
            if (value1.equals(value2)) {
                return true;
            }
        }

        return false;
    }

    private <T extends Annotation> T getParamAnnotation(Annotation[] annotations, 
                                                        Class<T> paramType) {
        T paramAnnotation = null;
        for (Annotation annotation : annotations) {
            if (annotation.annotationType() == paramType) {
                paramAnnotation = (T) annotation;
                break;
            }
        }
        return paramAnnotation;
    }
}