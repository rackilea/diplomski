public static void main(String[] args) throws Exception {
    Method method = Bar.class.getMethod("hashCode" /*, new Class<?>[] {...} */); // pass parameter types as needed
    System.out.println(method);
    System.out.println(overridesMethod(method, Bar.class));
}

public static boolean overridesMethod(Method method, Class<?> clazz) {
    return clazz == method.getDeclaringClass();
}

class Bar {
    /*
     * @Override public int hashCode() { return 0; }
     */
}