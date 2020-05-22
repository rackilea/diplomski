import static org.reflections.ReflectionUtils.withModifier;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Set;

import org.reflections.ReflectionUtils;

import accessmodifier.bar.MyClass;

import com.google.common.base.Predicates;

public class ReflectionTest
{

    public static void main(String[] args)
    {
        Class<MyClass> cls = MyClass.class;
        Set<Method> privateMethods = ReflectionUtils.getAllMethods(cls, withModifier(Modifier.PRIVATE));
        Set<Method> protectedMethods = ReflectionUtils.getAllMethods(cls, withModifier(Modifier.PROTECTED));
        Set<Method> publicMethods = ReflectionUtils.getAllMethods(cls, withModifier(Modifier.PUBLIC));
        Set<Method> defaultMethods = ReflectionUtils.getAllMethods(cls, Predicates.not(withModifier(Modifier.PRIVATE)), Predicates.not(withModifier(Modifier.PUBLIC)), Predicates.not(withModifier(Modifier.PROTECTED)));
        Set<Method> staticMethods = ReflectionUtils.getAllMethods(cls, withModifier(Modifier.STATIC));

        System.out.println("Private Methods");
        for (Method m : privateMethods)
            System.out.println(m.getName());

        System.out.println("\nProtected Methods");
        for (Method m : protectedMethods)
            System.out.println(m.getName());

        System.out.println("\nPublic Methods");
        for (Method m : publicMethods)
            System.out.println(m.getName());

        System.out.println("\nPackage-Private Methods");
        for (Method m : defaultMethods)
            System.out.println(m.getName());

        System.out.println("\nStatic Methods");
        for (Method m : staticMethods)
            System.out.println(m.getName());
    }
}