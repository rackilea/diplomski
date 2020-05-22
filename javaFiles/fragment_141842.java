@Configuration
public class ConverterConfiguration extends RepositoryRestConfigurerAdapter {

    @Autowired
    StringToOfferTypeConverter converter;

    @Override
    public void configureConversionService(ConfigurableConversionService conversionService) {
        conversionService.addConverter(converter);
        super.configureConversionService(conversionService);
    }
}