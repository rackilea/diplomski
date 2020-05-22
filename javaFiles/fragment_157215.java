class Test {
    // prints s once
    public static void method(String s) {
        System.out.println(s);
    }

    // prints s i times
    public static void method(String s, int i) {
        System.out.println(IntStream.rangeClosed(0, i - 1)
                .mapToObj($ -> s)
                .collect(Collectors.joining(" ")));
    }

    public static void main(String[] args) {
        perform();
    }

    public static Object perform() {
        final Scanner scanner = new Scanner(System.in);

        // read the method name
        final String methodName = scanner.nextLine();

        final Method[] methods = Arrays.stream(Test.class.getDeclaredMethods())
                .filter(m -> m.getName().endsWith(methodName) && !m.isSynthetic())
                .toArray(Method[]::new);

        // read the method parameter types in the format "type1 type2"
        final String rawMethodParametersTypes = scanner.nextLine();

        final SupportedType[] methodParameterTypes = Arrays.stream(rawMethodParametersTypes.split(" "))
                .map(p -> SupportedType.valueOf(p.toUpperCase()))
                .toArray(SupportedType[]::new);

        final Optional<Method> selectedMethod = Arrays.stream(methods)
                .filter(m -> Arrays.equals(Arrays.stream(methodParameterTypes)
                        .map(SupportedType::getType).toArray(Class<?>[]::new), m.getParameterTypes()))
                .findAny();

        if (!selectedMethod.isPresent()) {
            return null;
        }

        final Method method = selectedMethod.get();

        // read method arguments in the format "arg1 arg2"
        final String rawMethodArgumentsLine = scanner.nextLine();
        final String[] rawMethodArguments = rawMethodArgumentsLine.split(" ");

        final int expectedLength = method.getParameterCount();
        if (rawMethodArguments.length != expectedLength) {
            return null;
        }

        Object[] methodArguments = new Object[expectedLength];
        for (int i = 0; i < expectedLength; ++i) {
            methodArguments[i] = methodParameterTypes[i].getConverter().apply(rawMethodArguments[i]);
        }

        try {
            return method.invoke(null, methodArguments);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        return null;
    }
}