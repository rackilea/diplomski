@Bean
public ScriptTemplateConfigurer kotlinConfigurer() {
    ScriptTemplateConfigurer configurer = new ScriptTemplateConfigurer();
    configurer.setEngineName("kotlin");
    configurer.setScripts("scripts/render.kts");
    configurer.setRenderFunction("render");
    configurer.setSharedEngine(false);
    return configurer;
}

@Bean
public ViewResolver kotlinViewResolver(ScriptTemplateConfigurer kotlinConfigurer) {
    MyScriptTemplateViewResolver viewResolver = new MyScriptTemplateViewResolver();
    viewResolver.setPrefix("templates/");
    viewResolver.setSuffix(".kts");
    viewResolver.setScriptTemplateConfig(kotlinConfigurer);
    return viewResolver;
}