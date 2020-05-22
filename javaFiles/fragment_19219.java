RestAssured.config = RestAssuredConfig.config().objectMapperConfig(new ObjectMapperConfig().jackson2ObjectMapperFactory(
new Jackson2ObjectMapperFactory() {
        @Override
        public ObjectMapper create(Class aClass, String s) {
            FilterProvider filter = new SimpleFilterProvider().addFilter(...);
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.setFilters(filter);
            return objectMapper;
        }
    }
));