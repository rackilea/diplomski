@Test
public void test() throws JsonProcessingException {
    ObjectMapper mapper = new ObjectMapper();
    String json = mapper.writeValueAsString(new POJO().setHobbies(ImmutableMap.of("0", "Cricket", "1", "Chess")));
    System.out.println(json);
}

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MapAsField {

}

@Data
@Accessors(chain = true)
@JsonSerialize(using = CustomJsonSerializer.class)
public static class POJO {

    @JsonProperty("ID")
    private String id = "abc";
    @JsonProperty("NAME")
    private String name = "wener";
    @JsonProperty("AGE")
    private int age = 0;
    @JsonProperty("HOBBIES")
    @MapAsField
    private Map<String, String> hobbies = null;
    private Map<String, String> fav = ImmutableMap.of("A", "Yes", "B", "No");
}

static class CustomJsonSerializer extends JsonSerializer<Object> {

    @Override
    public void serialize(Object value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeStartObject();
        JavaType javaType = provider.constructType(Object.class);
        BeanDescription beanDesc = provider.getConfig().introspect(javaType);
        ListIterator<BeanPropertyDefinition> itor = beanDesc.findProperties()
            .listIterator();

        // Remove map field
        ArrayList<BeanPropertyDefinition> list = new ArrayList<>();
        while (itor.hasNext()) {
            BeanPropertyDefinition n = itor.next();

            if (n.getField().getAnnotated().getAnnotation(MapAsField.class) != null && // Only handle this
                Map.class.isAssignableFrom(n.getField().getRawType())) {
                itor.remove();
                list.add(n);
            }
        }

        JsonSerializer<Object> serializer = BeanSerializerFactory
            .instance
            .findBeanSerializer(provider, javaType, beanDesc);
        serializer.unwrappingSerializer(null).serialize(value, gen, provider);

        // Handle all map field
        for (BeanPropertyDefinition d : list) {
            try {
                Field field = d.getField().getAnnotated();
                field.setAccessible(true);
                Map<?, ?> v = (Map<?, ?>) field.get(value);
                if (v != null && !v.isEmpty()) {
                    for (Map.Entry o : v.entrySet()) {
                        gen.writeStringField(
                            String.format("%s[%s]", d.getName(), o.getKey().toString()),
                            o.getValue().toString()
                        );
                    }
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }

        gen.writeEndObject();
    }
}