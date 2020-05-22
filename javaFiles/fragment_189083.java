public class ColorTest {

    @Test
    public void convertToJson() throws JsonProcessingException {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(Colors.BLUE);
        assertEquals("\"blue\"", json);
    }

    private enum Colors {
        RED("red"), BLUE("blue");

        private String colorName;

        Colors(final String colorName) {
            this.colorName = colorName;
        }

        @JsonValue
        @Override
        public String toString() {
            return colorName;
        }
    }
}