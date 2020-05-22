@Configuration
@ComponentScan(basePackages="specifyappropriately", includeFilters=@Filter(type=FilterType.ANNOTATION, value=Controller.class))
public class MvcConfiguration extends WebMvcConfigurationSupport {

    @Bean
    public FormattingConversionService mvcConversionService() {
        FormattingConversionService conversionService = new ApplicationConversionServiceFactoryBean().getObject();
        addFormatters(conversionService);
        return conversionService;
    }

    public Validator getValidator() {
        return ...;
    }
}