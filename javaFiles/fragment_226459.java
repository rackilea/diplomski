@Override
protected MethodSecurityExpressionOperations createSecurityExpressionRoot(Authentication authentication, MethodInvocation invocation) {
    CustomMethodSecurityExpressionRoot root = new CustomMethodSecurityExpressionRoot(authentication);
    // Other initialization
    root.setMyService1(applicationContext.getBean(MyService1.class));
    root.setMyService2(applicationContext.getBean(MyService2.class));
    root.setMyService3(applicationContext.getBean(MyService3.class));
    return root;
}