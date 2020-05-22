public class SomeClass {

    <V, U> Queue<V> someMethod(String str, int a, List<U> list) {
        return null;
    }

    public static void main(String[] args) throws Exception {
        Method method = SomeClass.class.getDeclaredMethod("someMethod", String.class, int.class, List.class);

        TypeVariable<Method>[] typeParameters = method.getTypeParameters();
        System.out.println(typeParameters.length);                          // Prints "2"
        System.out.println(typeParameters[0].getName());                    // Prints "V"

        Class<?>[] parameterTypes = method.getParameterTypes();
        System.out.println(Arrays.toString(parameterTypes));                // Prints [class java.lang.String, int, interface java.util.List]

        Type[] genericParameterTypes = method.getGenericParameterTypes();
        System.out.println(genericParameterTypes[2].getTypeName());         // Prints java.util.List<U>
    }
}