public static void registerMyJsonSubtypes(ObjectMapper om, Object... reflectionArgs) {
    Reflections reflections = new Reflections(reflectionArgs);
    Set<Class<?>> types = reflections.getTypesAnnotatedWith(MyJsonSubtype.class);
    for (Class type : types) {
        String name = ((MyJsonSubtype) type.getAnnotation(MyJsonSubtype.class)).jsonTypeName();
        om.registerSubtypes(new NamedType(type, name));
    }
}