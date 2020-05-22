public class GenericSerializationTest {

    @Data //lombok
    public static class ItemListJSON<T> {
        private List<T> items;
    }

    @Data //lombok
    public static class StructureExample {
        private final String name;
        private final Double price;
    }

    public static class Sender {
        private final ObjectMapper objectMapper = new ObjectMapper();

        public <T> T sendRequest(String json, TypeReference typeReference) throws IOException {
            //sender logic - in this case I assume that json is API response
            return objectMapper.readValue(json, typeReference);
        }
    }

    @Test
    public void testMethod() throws IOException {
        Sender sender = new Sender();
        ItemListJSON<StructureExample> test = sender.sendRequest("{\"items\": [{\"name\":\"MacBook Pro\",\"price\":101.345}, {\"name\":\"MacMini\",\"price\":102.345}]}", new TypeReference<ItemListJSON<StructureExample>>() {});

        assertEquals("Should contain only 2 items", 2, test.getItems().size());
        assertEquals("Name of first item is not correct", "MacBook Pro", test.getItems().get(0).getName());
        assertEquals("Name of second item is not correct", "MacMini", test.getItems().get(1).getName());
    }
}