public class SerializerTest {
    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        addSerializers(module, Serializable.class, int.class, double.class, float.class, char.class, byte.class, short.class);
        objectMapper.registerModule(module);
        System.out.println(objectMapper.writeValueAsString(new A(10, "test", Arrays.asList(10000L, "TTTT2"))));
    }

    private static void addSerializers(SimpleModule module, Class... classes) {
        Arrays.stream(classes).forEach(c -> module.addSerializer(new Base64Serializer(c, false)));
    }
}