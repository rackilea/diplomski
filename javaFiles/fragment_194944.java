@SpringBootConfiguration
public class Application {

    @Autowired
    private BigDecimalDeserializer bigDecimalDeserializer;

    ...

    @Bean
    public Jackson2ObjectMapperBuilderCustomizer addCustomBigDecimalDeserialization() {
        return new Jackson2ObjectMapperBuilderCustomizer() {

            @Override
            public void customize(Jackson2ObjectMapperBuilder jacksonObjectMapperBuilder) {
                jacksonObjectMapperBuilder.deserializerByType(BigDecimal.class, bigDecimalDeserializer);
            }

        };
    }

    ...

}