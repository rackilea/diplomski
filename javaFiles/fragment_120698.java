@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {

    @Autowired
    private WebMvcConfigDetails details;

    @Override
    protected void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.addAll(details.converters);
    }
}