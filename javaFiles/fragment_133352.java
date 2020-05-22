@Configuration
@EnableWebMvc
...
public class WebConfig extends WebMvcConfigurerAdapter
{

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) 
    {
        Jackson2ObjectMapperBuilder builder = new CustomObjectMapperBuilder();
        converters.add(new MappingJackson2HttpMessageConverter(builder.build()));
    }

}