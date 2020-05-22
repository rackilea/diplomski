public static class DateDeserializer extends StdScalarDeserializer<Object> {
        public DateDeserializer() {
            super(Object.class);
        }
        @Override
        public Object deserialize(JsonParser p, DeserializationContext ctxt)
                throws IOException {
            String valueAsString = p.getValueAsString();
            try {
                DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
                return formatter.parse(valueAsString);
            } catch (Exception e) {
                //you could add extra logic to parse other types
                return valueAsString;
            }
        }
    }