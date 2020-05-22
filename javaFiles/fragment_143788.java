import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.*;
import javax.xml.bind.annotation.*;

public class GetAnnotationsOfPackage {

    @XmlRootElement(name="RootElement")
    @XmlAccessorType(XmlAccessType.FIELD)
    public class Root {
        @XmlElement(name="SubElement")
        public String subElement;
    }

    public static void main(String[] args) {
        List<Annotation> as = getAnnotationsOfPackage(Root.class, "javax.xml.bind.annotation");
        for (Annotation annotation : as) {
            System.out.println(annotation.annotationType().getName());
        }
    }

    public static List<Annotation> getAnnotationsOfPackage(Class<?> classToCheck, String annotationsPackage) {
        List<Annotation> annotationsList = getAllAnnotationsOfPackage(classToCheck, annotationsPackage);
        Method[] ms = classToCheck.getDeclaredMethods();
        for (int i = 0; i < ms.length; i++) {
            annotationsList.addAll(getAllAnnotationsOfPackage(ms[i], annotationsPackage));
        }
        Field[] fs = classToCheck.getDeclaredFields();
        for (int i = 0; i < fs.length; i++) {
            annotationsList.addAll(getAllAnnotationsOfPackage(fs[i], annotationsPackage));
        }
        return annotationsList;
    }

    public static List<Annotation> getAllAnnotationsOfPackage(AnnotatedElement annotatedElement, String annotationsPackage) {
        Annotation[] as = annotatedElement.getAnnotations();
        List<Annotation> asList = new LinkedList<Annotation>();
        for (int i = 0; i < as.length; i++) {
            if (as[i].annotationType().getPackage().getName().startsWith(annotationsPackage)) {
                asList.add(as[i]);
            }
        }
        return asList;
    }
}