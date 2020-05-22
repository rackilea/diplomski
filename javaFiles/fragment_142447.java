@Bean
@Scope(value="client",proxyMode = ScopedProxyMode.INTERFACES)
@Primary
MyService myService(){
    //does not really matter, which instance you create here
    //the scope will create the real instance
    //may be you can even return null, did not try that.
    return new MyServiceDummy();
}