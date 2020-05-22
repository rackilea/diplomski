public static boolean test(List<?> propertyList, String methodName) throws Exception {
    Method method = propertyList.get(0).getClass().getDeclaredMethod(methodName);
    return !propertyList.stream().map(toFunction(method)).allMatch(new HashSet<>()::add);
}
public static Function toFunction(Method m) throws IllegalAccessException {
    return MethodHandleProxies.asInterfaceInstance(Function.class,
        MethodHandles.lookup().unreflect(m));
}