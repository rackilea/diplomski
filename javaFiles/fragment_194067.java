package jvm;

import javax.tools.ToolProvider;

public class GetArrayClass {
    public static Class<?> viaGetClass() {
        return new String[0].getClass();
    }
    public static Class<?> viaClassLiteral() {
        return String[].class;
    }
    public static void main(String[] args) {
        decompile();
    }
    private static void decompile() {
        Object args = new String[]{"-c", GetArrayClass.class.getName()};
        try {
            ToolProvider.getSystemJavaCompiler().getClass().getClassLoader()
                .loadClass("com.sun.tools.javap.Main")
                .getMethod("main", String[].class).invoke(null, args);
        } catch(ReflectiveOperationException ex) {
            throw new IllegalStateException(ex);
        }
    }
    private GetArrayClass(){}
}