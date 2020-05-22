@Bean     
@Profile('prod')    
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public MyBean myBeanProd() {
    return getMyBean()
}

@Bean   
@Profile('test')    
@Scope(value = "singleton", proxyMode = ScopedProxyMode.TARGET_CLASS)
public MyBean myBeanWithoutRequestScope() {
    return getMyBean()
}

privateMyBean getMyBean() {
    return new MyBean(); // actually it is a more complex initialization
}