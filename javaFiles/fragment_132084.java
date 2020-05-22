import java.lang.annotation.Annotation;

import org.codehaus.jackson.Version;
import org.codehaus.jackson.Versioned;
import org.codehaus.jackson.map.AnnotationIntrospector;
import org.codehaus.jackson.map.JsonDeserializer;
import org.codehaus.jackson.map.KeyDeserializer;
import org.codehaus.jackson.map.annotate.JsonSerialize.Typing;
import org.codehaus.jackson.map.introspect.Annotated;
import org.codehaus.jackson.map.introspect.AnnotatedClass;
import org.codehaus.jackson.map.introspect.AnnotatedConstructor;
import org.codehaus.jackson.map.introspect.AnnotatedField;
import org.codehaus.jackson.map.introspect.AnnotatedMethod;
import org.codehaus.jackson.map.introspect.AnnotatedParameter;
import org.codehaus.jackson.type.JavaType;
import org.codehaus.jackson.util.VersionUtil;

public class ApiAnnotationIntrospector extends AnnotationIntrospector implements
        Versioned {

    @Override
    public Version version() {
        return VersionUtil.versionFor(getClass());
    }

    @Override
    public boolean isHandled(Annotation ann) {
        Class<?> cls = ann.annotationType();
        if (ApiField.class == cls) {
            return true;
        }
        return false;
    }

    @Override
    public String findRootName(AnnotatedClass ac) {
        return null;
    }

    @Override
    public String[] findPropertiesToIgnore(AnnotatedClass ac) {
        return null;
    }

    @Override
    public Boolean findIgnoreUnknownProperties(AnnotatedClass ac) {
        return null;
    }

    @Override
    public boolean isIgnorableMethod(AnnotatedMethod m) {
        return false;
    }

    @Override
    public boolean isIgnorableConstructor(AnnotatedConstructor c) {
        return false;
    }

    @Override
    public boolean isIgnorableField(AnnotatedField f) {
        return false;
    }

    @Override
    public Object findSerializer(Annotated am) {
        return null;
    }

    @Override
    public Class<?> findSerializationType(Annotated a) {
        return null;
    }

    @Override
    public Typing findSerializationTyping(Annotated a) {
        return null;
    }

    @Override
    public Class<?>[] findSerializationViews(Annotated a) {
        return null;
    }

    @Override
    public String[] findSerializationPropertyOrder(AnnotatedClass ac) {
        return null;
    }

    @Override
    public Boolean findSerializationSortAlphabetically(AnnotatedClass ac) {
        return null;
    }

    @Override
    public String findGettablePropertyName(AnnotatedMethod am) {
        return null;
    }

    @Override
    public boolean hasAsValueAnnotation(AnnotatedMethod am) {
        return false;
    }

    @Override
    public String findEnumValue(Enum<?> value) {
        return null;
    }

    @Override
    public String findSerializablePropertyName(AnnotatedField af) {
        return getPropertyName(af);
    }

    @Override
    public Object findDeserializer(Annotated am) {
        return null;
    }

    @Override
    public Class<? extends KeyDeserializer> findKeyDeserializer(Annotated am) {
        return null;
    }

    @Override
    public Class<? extends JsonDeserializer<?>> findContentDeserializer(
            Annotated am) {
        return null;
    }

    @Override
    public Class<?> findDeserializationType(Annotated am, JavaType baseType,
            String propName) {
        return null;
    }

    @Override
    public Class<?> findDeserializationKeyType(Annotated am,
            JavaType baseKeyType, String propName) {
        return null;
    }

    @Override
    public Class<?> findDeserializationContentType(Annotated am,
            JavaType baseContentType, String propName) {
        return null;
    }

    @Override
    public String findSettablePropertyName(AnnotatedMethod am) {
        return null;
    }

    @Override
    public String findDeserializablePropertyName(AnnotatedField af) {
        return getPropertyName(af);
    }

    @Override
    public String findPropertyNameForParam(AnnotatedParameter param) {
        return null;
    }

    private String getPropertyName(AnnotatedField af) {
        ApiField annotation = af.getAnnotation(ApiField.class);
        if (annotation != null && annotation.value() != "") {
            return annotation.value();
        }
        return null;
    }

}