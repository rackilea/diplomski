protected List<FrameworkMethod> computeTestMethods() {
    List<FrameworkMethod> methods = new ArrayList<>(); 
    methods.addAll(getTestClass().getAnnotatedMethods(Test.class));
    methods.addAll(getTestClass().getAnnotatedMethods(MyTest.class));
    return methods;
}