ExternalClass ext = //obtain target ExternalClass somehow
ExternalClassFacade extFacade = (ExternalClassFacade) Proxy.newProxyInstance(
    ExternalClass.class.getClassLoader(), 
    new Class<?>[]{ExternalClassFacade.class},
    new BatchInvocationHandler(ext));
extFacade.method1();