import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.Set;

import org.reflections.Reflections;
import org.reflections.scanners.MethodAnnotationsScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;

public class RunClass {
    public static void main(String args[]) throws Exception {
        runAllAnnotatedWith(mod.class);
    }

    public static void runAllAnnotatedWith(Class<? extends Annotation> annotation) throws Exception {
        Reflections reflections = new Reflections(new ConfigurationBuilder()
                .setUrls(ClasspathHelper.forJavaClassPath()).setScanners(
                        new MethodAnnotationsScanner()));
        Set<Method> methods = reflections.getMethodsAnnotatedWith(annotation);

        for (Method m : methods) {
            m.invoke(null); // for simplicity, invoking static methods without parameters
        }
    }

    @mod(name = "me1")
    public static void calledcs() {
        System.out.println("called");
    }

    @mod(name = "me2")
    public static void calledcs2() {
        System.out.println("called2");
    }
}

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface mod {
    String name() default "";
}