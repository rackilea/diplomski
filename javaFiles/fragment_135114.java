public static boolean Debug(Object variable, Class<?> testClass) {
    if (testClass.isInstance(variable)) {
            return true;
    }
    return false;
}