@Bean(initMethod="initialize")
@Scope(value = "tenant", proxyMode = ScopedProxyMode.INTERFACES)
public ITemplateResolver databaseTemplateResolver() {

    final DatabaseTemplateResolver resolver = 
        new DatabaseTemplateResolver(systemSettingService, emailTemplateService );

    resolver.setTemplateMode("HTML5");
    resolver.setCacheTTLMs((long) (1000*60*5)); // 5 Minutes
    resolver.setOrder(2);

    return resolver;
}