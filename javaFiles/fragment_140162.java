class MethodInterceptor {

    public static void intercept(@Origin Method method) {
        System.out.println("Intercepted: " + method.getName());
    }

    public static void intercept(@Origin Constructor<?> constructor) {
        System.out.println("Intercepted: " + constructor.getName());
    }
}