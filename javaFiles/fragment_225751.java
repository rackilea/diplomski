@Bean
public ITemplateResolver templateResolver()
{
    ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
    templateResolver.setPrefix("templates/");
    templateResolver.setSuffix(".html");
    templateResolver.setTemplateMode(TemplateMode.HTML);

    return templateResolver;
}

@Bean
public TemplateEngine templateEngine()
{
    TemplateEngine templateEngine = new TemplateEngine();
    templateEngine.setTemplateResolver(this.templateResolver());

    return templateEngine;
}