for (Method method : m) {
    System.out.println(method.getName());
    for (Class<?> argClass : m.getParameterTypes()) {
        System.out.println("  " + argClass.getName());
    }
}