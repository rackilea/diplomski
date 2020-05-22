public class Test {

    public static void main(String[] args) throws Exception {
        ObjectMapper om = new ObjectMapper();
        Parameter p = om.readValue("{\"prevValue\": 101044012342343543}", Parameter.class);
        System.out.println(p.prevValue);
    }

    public static class Number2StringDesrializer extends JsonDeserializer<String> {

        @Override
        public String deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
            Number n = p.getNumberValue();
            return n.toString();
        }

    }

    public static class Parameter {

        @JsonDeserialize(using = Number2StringDesrializer.class)
        private String prevValue;

        public void setPrevValue(String prevValue) {
            this.prevValue = prevValue;
        }


        public String getPrevValue() {
            return prevValue;
        }
    }
}