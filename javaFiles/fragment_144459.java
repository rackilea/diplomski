new BeanMappingBuilder() {
    configure() {
        mapping(ObjectWithList.class, ObjectWithWrapper.class,
            .fields("list.wrappedList", "list")
    }
}