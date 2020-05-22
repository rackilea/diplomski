@Configuration
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {

@Override
public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
    converters.clear();

    converters.add(marshallingHttpMessageConverter());
    converters.add(marshallingHttpMessageConverterJson());
}