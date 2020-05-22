import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Member;
import static java.lang.System.out;

enum ClassMember { CONSTRUCTOR, FIELD, METHOD, CLASS, ALL }

public class ClassSpy {
    public static void main(String... args) {
    try {
        Class<?> c = Class.forName(args[0]);
        out.format("Class:%n  %s%n%n", c.getCanonicalName());

        Package p = c.getPackage();
        out.format("Package:%n  %s%n%n",
               (p != null ? p.getName() : "-- No Package --"));

        for (int i = 1; i < args.length; i++) {
        switch (ClassMember.valueOf(args[i])) {
        case CONSTRUCTOR:
            printMembers(c.getConstructors(), "Constructor");
            break;
        case FIELD:
            printMembers(c.getFields(), "Fields");
            break;
        case METHOD:
            printMembers(c.getMethods(), "Methods");
            break;
        case CLASS:
            printClasses(c);
            break;
        case ALL:
            printMembers(c.getConstructors(), "Constuctors");
            printMembers(c.getFields(), "Fields");
            printMembers(c.getMethods(), "Methods");
            printClasses(c);
            break;
        default:
            assert false;
        }
        }

        // production code should handle these exceptions more gracefully
    } catch (ClassNotFoundException x) {
        x.printStackTrace();
    }
    }