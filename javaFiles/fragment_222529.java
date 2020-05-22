@Bean
@Qualifier("standardMapper")
public ObjectMapper standardObjectMapper() {
    ObjectMapper mapper = createMapper();
    SimpleModule module = new SimpleModule();
    module.addSerializer(Product.class, new StandardProductSerializer());
    mapper.registerModule(module);
    return mapper;
}

@Bean
@Qualifier("specialMapper")
public ObjectMapper specialObjectMapper() {
    ObjectMapper mapper = createMapper();
    SimpleModule module = new SimpleModule();
    // In this mapper, I have a different serializer for the Product class
    module.addSerializer(Product.class, new SpecialProductSerializer());
    mapper.registerModule(module);
    return mapper;
}