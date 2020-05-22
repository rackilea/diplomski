@Bean
public RemoteJco jcoPool(){
    RmiProxyFactoryBean jcoPool = new RmiProxyFactoryBean();
    jcoPool.setServiceUrl("rmi://localhost/CH");
    jcoPool.setServiceInterface(RemoteJco.class);
    jcoPool.setRefreshStubOnConnectFailure(true);
    jcoPool.afterPropertiesSet();
    return (RemoteJco) jcoPool.getObject();
}