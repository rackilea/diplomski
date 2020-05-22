public static boolean test(List<?> propertyList, String methodName) throws Exception{
    Method method = propertyList.get(0).getClass().getDeclaredMethod(methodName);

    return !propertyList.stream().map(x -> {
        try {
            return method.invoke(x);
        } catch (ReflectiveOperationException ex) {
            throw new RuntimeException("invoking "+method, ex);
        }
    }).allMatch(new HashSet<>()::add);
}