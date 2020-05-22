@Bean
public Module getLocalDateModule() {
    SimpleModule sm = new SimpleModule("LocalDateModule");
    sm.addSerializer(LocalDate.class, new JsonSerializer<LocalDate>() {
        @Override
        public void serialize(LocalDate localDate, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
            jsonGenerator.writeString(localDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'00:00:00.000'Z'")));
        }
    });
    return sm;
}