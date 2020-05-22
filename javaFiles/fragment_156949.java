@Configuration
@ConditionalOnClass(ApiModuleAConfiguration.class)
@ConditionalOnProperty(prefix = "project.moduleA.", value = "enabled")
public class ApiModuleAAutoConfiguration extends AbstractApiModuleAutoConfiguration<ApiModuleAConfiguration> {

    public static final String API_MODULE_A_DISPATCHER_SERVLET_BEAN_NAME = "apiModuleADispatcherServlet";
    public static final String API_MODULE_A_DISPATCHER_SERVLET_REGISTRATION_BEAN_NAME = "apiModuleADispatcherServletRegistration";

    @Value("${project.moduleA.path}")
    private String apiModuleAPath;

    @Bean(name = API_MODULE_A_DISPATCHER_SERVLET_BEAN_NAME)
    public DispatcherServlet apiModuleADispatcherServlet() {
        return createApiModuleDispatcherServlet();
    }

    @Bean(name = API_MODULE_A_DISPATCHER_SERVLET_REGISTRATION_BEAN_NAME)
    public ServletRegistrationBean apiModuleADispatcherServletRegistration() {
        return createApiModuleDispatcherServletRegistration(apiModuleADispatcherServlet());
    }

    @Override
    protected String getApiModuleDispatcherServletBeanName() {
        return API_MODULE_A_DISPATCHER_SERVLET_BEAN_NAME;
    }

    @Override
    protected String getApiModulePath() {
        return apiModuleAPath;
    }

    @Override
    protected Class<ApiModuleAConfiguration> getApiModuleConfigurationClass() {
        return ApiModuleAConfiguration.class;
    }

}