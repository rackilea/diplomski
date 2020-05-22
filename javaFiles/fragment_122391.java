@Bean
    public ObjectMapper jsonObjectMapper() {
        final ObjectMapper jsonMapper = new ObjectMapper();
        jsonMapper.registerModule(new JavaTimeModule());
        jsonMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        //some other configuration like:
        jsonMapper.registerModule(new Jdk8Module());
        jsonMapper.disable(SerializationFeature.WRITE_DATE_TIMESTAMPS_AS_NANOSECONDS);

        return jsonMapper;
    }