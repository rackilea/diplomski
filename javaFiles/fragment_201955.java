class FooMapperImpl<S> implements Mapper<Foo, S> {
    public Foo fromMap(S map) {
        ObjectMapper objectMapper = new ObjectMapper();
        Foo obj = objectMapper
                .convertValue(map, Foo.class);
        return obj;
    }
}