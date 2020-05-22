@Bean
@Scope(value=WebApplicationContext.SCOPE_REQUEST, proxyMode=ScopedProxyMode.TARGET_CLASS)
public PlatformTransactionManager txManager(SessionInfo sessionInfo, DataSourceManager dsManager)   
{               
    return dsManager.getTransactionManager(sessionInfo.getCustomerId()); 
}