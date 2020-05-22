public class JacksonInterpolateString {
    static final String JSON = "{ \"file\":\"${sys:user.home}/path/to/my_file\" }";

    public static class Bean {
        public File file;

        @Override
        public String toString() {
            return file.toString();
        }
    }

    private static class MyJsonParser extends JsonParserDelegate {

        public MyJsonParser(final JsonParser d) {
            super(d);
        }

        @Override
        public String getText() throws IOException {
            final String value = super.getText();
            if (value != null) {
                return interpolateString(value);
            }
            return value;
        }

        @Override
        public String getValueAsString() throws IOException {
            return getValueAsString(null);
        }

        @Override
        public String getValueAsString(final String defaultValue) throws IOException {
            final String value = super.getValueAsString(defaultValue);
            if (value != null) {
                return interpolateString(value);
            }
            return null;
        }
    }

    private static class MyMappingJsonFactory extends MappingJsonFactory {
        @Override
        protected JsonParser _createParser(
                final char[] data,
                final int offset,
                final int len,
                final IOContext ctxt,
                final boolean recyclable)
                throws IOException {
            return new MyJsonParser(super._createParser(data, offset, len, ctxt, recyclable));
        }

        @Override
        protected JsonParser _createParser(final Reader r, final IOContext ctxt)
                throws IOException {
            return new MyJsonParser(super._createParser(r, ctxt));
        }

    }

    private static String interpolateString(final String value) {
        return value.replace("${sys:user.home}", "/home/user");
    }

    public static void main(String[] args) throws IOException {
        final JsonFactory factory = new MyMappingJsonFactory();
        final ObjectMapper mapper = new ObjectMapper(factory);
        System.out.println(mapper.readValue(JSON, Map.class));
        System.out.println(mapper.readValue(JSON, Bean.class));
    }

}