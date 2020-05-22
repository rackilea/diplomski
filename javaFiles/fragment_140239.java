@Test
public void test2() throws JsonProcessingException {
    ObjectMapper mapper = new ObjectMapper();
    mapper.registerModule(new SimpleModule().setSerializerModifier(new MapAsFieldModifier()));
    System.out.println(mapper.writeValueAsString(new POJO2()));
}
@Data
@Accessors(chain = true)
public static class POJO2 {

    @JsonProperty("ID")
    private String id = "abc";
    @JsonProperty("NAME")
    private String name = "wener";
    @JsonProperty("AGE")
    private int age = 0;
    @JsonProperty("HOBBIES")
    @MapAsField
    private Map<String, String> hobbies = ImmutableMap.of("0", "Cricket", "1", "Chess");
    private Map<String, String> fav = ImmutableMap.of("A", "Yes", "B", "No");
}

public class MapAsFieldModifier extends BeanSerializerModifier {

    @Override
    public JsonSerializer<?> modifySerializer(SerializationConfig config, BeanDescription beanDesc,
        JsonSerializer<?> serializer) {
        ListIterator<BeanPropertyDefinition> itor = beanDesc.findProperties().listIterator();
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

        // We should handle this
        if (!list.isEmpty()) {

            return new JsonSerializer<Object>() {
                @Override
                public void serialize(Object value, JsonGenerator gen, SerializerProvider serializers)
                    throws IOException, JsonProcessingException {
                    gen.writeStartObject();

                    JavaType javaType = serializers.constructType(value.getClass());
                    JsonSerializer<Object> ser = BeanSerializerFactory
                        .instance
                        .findBeanSerializer(serializers, javaType, beanDesc);

                    ser.unwrappingSerializer(null).serialize(value, gen, serializers);

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
            };
        }

        return serializer;
    }
}