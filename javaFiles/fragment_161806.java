BeanMappingBuilder mappingBuilder = new BeanMappingBuilder() {
    @Override
    protected void configure() {

        String dateFormat = "MM/dd/yyyy HH:mm";

        mapping(TestObject.class, TestObjectPrime.class,
                TypeMappingOptions.wildcard(true),
                TypeMappingOptions.dateFormat(dateFormat))
                .fields("dateString", "dateObject");

        mapping(SomeObject.class, SomeOtherObject.class,
                TypeMappingOptions.dateFormat(dateFormat))
                .fields("srcField", "destField");
    }
};

DozerBeanMapper apiBeanMapper = new DozerBeanMapper();
apiBeanMapper.addMapping(mappingBuilder);