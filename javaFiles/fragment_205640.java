@Import(HibernateConfig.class)
@EnableWebMvc
// @EnableAsync()
// @EnableAspectJAutoProxy
@ComponentScan(basePackages = "com.azim.web.service.*",  basePackageClasses = { WebSecurityConfig.class }, excludeFilters = { @ComponentScan.Filter(Configuration.class) })
public class WebConfig extends WebMvcConfigurerAdapter {

    @Override
    protected void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.favorPathExtension(false).favorParameter(true).parameterName("mediaType").ignoreAcceptHeader(true).useJaf(false).defaultContentType(MediaType.APPLICATION_JSON)
                .mediaType("xml", MediaType.APPLICATION_XML).mediaType("json", MediaType.APPLICATION_JSON).mediaType("html", MediaType.APPLICATION_JSON);
    }

    @Bean(name = "validator")
    public Validator validator() {
        return new LocalValidatorFactoryBean();
    }
}