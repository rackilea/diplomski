...
imports
...
@Configuration
@EnableWebMvc
@ComponentScan("com.myapp.controllers")
public class WebConfiguration extends WebMvcConfigurerAdapter {

    private static final String TEMPLATE_RESOLVER_PREFIX = "/WEB-INF/templates/";
    private static final String TEMPLATE_RESOLVER_SUFFIX = ".html";
    private static final String TEMPLATE_RESOLVER_TEMPLATE_MODE = "HTML5";

    @Bean
    public ViewResolver viewResolver() {
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setTemplateEngine(templateEngine());

        return viewResolver;
    }

    @Bean
    public TemplateEngine templateEngine() {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver());

        return templateEngine;
    }

    @Bean
    public TemplateResolver templateResolver() {
        TemplateResolver templateResolver = new ServletContextTemplateResolver();
        templateResolver.setPrefix(TEMPLATE_RESOLVER_PREFIX);
        templateResolver.setSuffix(TEMPLATE_RESOLVER_SUFFIX);
        templateResolver.setTemplateMode(TEMPLATE_RESOLVER_TEMPLATE_MODE);

        return templateResolver;
    }