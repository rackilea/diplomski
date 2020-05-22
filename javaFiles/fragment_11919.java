import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;

import static java.lang.System.out;

/**
 * Uses JDK 8 Parameter class to demonstrate metadata related to the parameters
 * of the methods and constructors of the provided class (includes private,
 * protected, and public methods, but does not include methods inherited from
 * parent classes; those classes should be individually submitted).
 *
 * @author Dustin
 */
public class Main {
    private static void displayParametersMetadata(final String className) {
        try {
            final Class clazz = Class.forName(className);

            // Get all class's declared methods (does not get inherited methods)
            final Method[] declaredMethods = clazz.getDeclaredMethods();
            for (final Method method : declaredMethods) {
                writeHeader(
                        "Method " + method.toGenericString()
                                + " has " + method.getParameterCount() + " Parameters:");
                int parameterCount = 0;
                final Parameter[] parameters = method.getParameters();
                for (final Parameter parameter : parameters) {
                    out.println(
                            "\targ" + parameterCount++ + ": "
                                    + (parameter.isNamePresent() ? parameter.getName() : "Parameter Name not provided,")
                                    + (isParameterFinal(parameter) ? " IS " : " is NOT ")
                                    + "final, type " + parameter.getType().getCanonicalName()
                                    + ", and parameterized type of " + parameter.getParameterizedType()
                                    + " and " + (parameter.isVarArgs() ? "IS " : "is NOT ")
                                    + "variable.");
                }
            }
        } catch (ClassNotFoundException cnfEx) {
            out.println("Unable to find class " + className);
        }
    }

    private static void writeHeader(final String headerText) {
        out.println("\n==========================================================");
        out.println("= " + headerText);
        out.println("==========================================================");
    }

    /**
     * Indicate whether provided Parameter is final.
     *
     * @param parameter Parameter to be tested for 'final' modifier.
     * @return {@code true} if provided Parameter is 'final'.
     */
    private static boolean isParameterFinal(final Parameter parameter) {
        return Modifier.isFinal(parameter.getModifiers());
    }

    public static void main(final String[] arguments) {
        displayParametersMetadata("TestProperties");
    }
}