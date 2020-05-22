@Bean
public HessianProxyFactoryBean accountService() {
    HessianProxyFactoryBean factory = new HessianProxyFactoryBean();
    factory.setServiceUrl("http://remotehost:8080/remoting/AccountService");
    factory.setServiceInterface(AccountService.class);
    return factory;
}