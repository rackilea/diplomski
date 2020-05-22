public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {
    return methods.stream()
        .collect(groupingBy(IMethodInstance::getInstance))
        .entrySet()
        .stream()
        .flatMap(e -> 
            ReflectionUtils.shouldBeInvoked(e.getKey().getClass(), OrderByDeclarationListener.class) ?  
            e.getValue().stream().sorted(byDeclaration()) : 
            e.getValue().stream())
        .collect(toList());
}