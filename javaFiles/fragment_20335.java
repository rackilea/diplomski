import java.util.Set;

import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner ;

public class Test {
    public static Set<Class<?>> getClassesFromPackage(String packageName) {
        Reflections reflections = new Reflections(packageName, new SubTypesScanner(false));

        return reflections.getSubTypesOf(Object.class);
    }

    public static void main(String ... args) {
        for ( Class c: getClassesFromPackage("scala") ) {
            System.out.println(c.getName());
        }
    }
}