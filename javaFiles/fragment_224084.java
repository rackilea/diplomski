public class ObjectMapperConfigurer {
    public static ObjectMapper configureObjectMapper(ObjectMapper objectMapper) {
        return objectMapper.registerModules(
                // First three modules can be found here. https://github.com/FasterXML/jackson-modules-java8
                new Jdk8Module(), // support for other new Java 8 datatypes outside of date/time: most notably Optional, OptionalLong, OptionalDouble
                new JavaTimeModule(), // support for Java 8 date/time types (specified in JSR-310 specification)
                new ParameterNamesModule(), // Support for detecting constructor and factory method ("creator") parameters without having to use @JsonProperty annotation
                // Manually registering my serializer. 
                new SimpleModule().addSerializer(Page.class, pageJsonSerializer),
... all the same
}