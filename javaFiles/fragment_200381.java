public static void main(String[] args) throws JsonProcessingException {
        Foo2 message = new Foo2("valueMessage", "variableMessage");
        Foo2 title = new Foo2("valueTitle", "variableTitle");
        Foo foo = new Foo(title, message);
        ObjectMapper mapper = new ObjectMapper();

        SimpleModule module = new SimpleModule();
        module.addSerializer(Foo.class, new FooSerializer());
        mapper.registerModule(module);

        String serialized = mapper.writeValueAsString(foo);
        System.out.println(serialized);

}