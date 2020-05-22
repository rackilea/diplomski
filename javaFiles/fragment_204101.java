public class JacksonInjectExample {
    private static final String JSON = "{\"field1\":\"value1\", \"field2\":123}";

    // HttpResponse in your case
    public static class ExternalObject {
        @Override
        public String toString() {
            return "MyExternalObject";
        }
    }

    public static class Bean {
        // make fields public to avoid writing getters in this example
        public String field1;
        public int field2;

        private ExternalObject external;

        public Bean(@JacksonInject final ExternalObject external) {
            this.external = external;
        }

        @Override
        public String toString() {
            return "Bean{" +
                    "field1='" + field1 + '\'' +
                    ", field2=" + field2 +
                    ", external=" + external +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {
        final ObjectMapper mapper = new ObjectMapper();
        final InjectableValues.Std injectableValues = new InjectableValues.Std();
        injectableValues.addValue(ExternalObject.class, new ExternalObject());
        mapper.setInjectableValues(injectableValues);

        final Bean bean = mapper.readValue(JSON, Bean.class);
        System.out.println(bean);
    }
}