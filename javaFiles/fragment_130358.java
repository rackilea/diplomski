public class MyAppConversionServiceFactoryBean implements
        FactoryBean<ConversionService>, InitializingBean {

    @Autowired
    private Set<BaseConverter> converters;

}