package SO;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;

public class jr {
    // Modifiers that can be applied to a method in source code
    private static final int LANGUAGE_MODIFIERS = Modifier.PUBLIC | Modifier.PROTECTED | Modifier.PRIVATE
        | Modifier.ABSTRACT | Modifier.STATIC | Modifier.FINAL | Modifier.SYNCHRONIZED | Modifier.NATIVE;

    public static void main(String[] args) throws ClassNotFoundException {
    jr j = new jr();

    String str = "java.lang.Integer";

    Class<?> cls = Class.forName(str);
    j.print(cls);
    }

    /*
     * Displays the Methods of the given class. The items displayed depends on
     * the options entered.
     * 
     * @param cl The class to be displayed
     */
    public void methods(Class cl) {
    // Get the Methods of the Class cl
    Method[] me = cl.getDeclaredMethods();

    for (Method x : me) {
        String parameterType = "";
        System.out.println("simple   :" + x);
        System.out.println("generic  :" + x.toGenericString());
        System.out.println("modified :" + modifiedToGenericString(x));
        ;

    }
    }

    public String modifiedToGenericString(Method m) {
    try {
        StringBuilder sb = new StringBuilder();
        int mod = m.getModifiers() & LANGUAGE_MODIFIERS;
        if (mod != 0) {
        sb.append(Modifier.toString(mod) + " ");
        }
        Type[] typeparms = m.getTypeParameters();
        if (typeparms.length > 0) {
        boolean first = true;
        sb.append("<");
        for (Type typeparm : typeparms) {
            if (!first)
            sb.append(",");
            if (typeparm instanceof Class)
            sb.append(((Class) typeparm).getSimpleName());
            else
            sb.append(typeparm.toString());
            first = false;
        }
        sb.append("> ");
        }

        Type genRetType = m.getGenericReturnType();
        sb.append(((genRetType instanceof Class) ? ((Class) genRetType).getSimpleName() : genRetType.toString())
            + " ");

        // sb.append((m.getDeclaringClass()) + ".");
        sb.append(m.getName() + "(");
        Type[] params = m.getGenericParameterTypes();
        for (int j = 0; j < params.length; j++) {
        sb.append((params[j] instanceof Class) ? ((Class) params[j]) : (params[j].toString()));
        if (j < (params.length - 1))
            sb.append(",");
        }
        sb.append(")");
        Type[] exceptions = m.getGenericExceptionTypes();
        if (exceptions.length > 0) {
        sb.append(" throws ");
        for (int k = 0; k < exceptions.length; k++) {
            sb.append((exceptions[k] instanceof Class) ? ((Class) exceptions[k]).getSimpleName()
                : exceptions[k].toString());
            if (k < (exceptions.length - 1))
            sb.append(",");
        }
        }
        return sb.toString();
    } catch (Exception e) {
        return "<" + e + ">";
    }
    }

    /*
     * Displays the information about the class. Uses the options to filter
     * which information is printed.
     * 
     * @param cl The class to be displayed
     */
    public void print(Class cl) {
    System.out.println("\nMETHODS:");
    methods(cl);
    }
}