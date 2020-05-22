public static void main(String... args) throws ClassNotFoundException {
    String[] classAndMethod = args[0].split("#");
    Object[] parameters = new Object[] {"constructor parameter"};

    Class<?> className = Class.forName(classAndMethod[0]);
    String methodName = classAndMethod[1];

    Request request = createRequest(parameters, className, methodName);

    Result result = new JUnitCore().run(request);

    System.exit(result.wasSuccessful() ? 0 : 1);
}

private static Request createRequest(Object[] parameters, Class<?> className, String methodName) {
        Description method = Description.createTestDescription(className, methodName);
        return new ConstructorParameterRequest(className, parameters).filterWith(method);
}