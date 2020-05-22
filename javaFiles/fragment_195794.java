@Bean
public TemplateEngine templateEngine() {
    SpringTemplateEngine engine = new SpringTemplateEngine();
    engine.setTemplateResolver(templateResolver());
    engine.addDialect(securityDialect());
    return engine;
}

private IDialect securityDialect(){
    SpringSecurityDialect dialect = new SpringSecurityDialect();
    return dialect;
}