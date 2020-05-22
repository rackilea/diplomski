public static <T> boolean test(
    List<? extends T> propertyList, Class<T> type, String methodName) throws Exception {

    Method method = type.getMethod(methodName);
    return !propertyList.stream().map(toFunction(method)).allMatch(new HashSet<>()::add);
}