private PropertyFilter allFilter = new SimpleBeanPropertyFilter() {
    @Override
    public void serializeAsField(
            Object pojo,
            JsonGenerator jgen,
            SerializerProvider provider,
            PropertyWriter writer) throws Exception {

        // If it is not the "all" property, go on with normal serialization
        if (!writer.getName().equals("all")) {
            writer.serializeAsField(pojo, jgen, provider);
            return;
        }

        // Else, check the special all-rule
        final EODPrice eodPrice = (EODPrice) pojo;
        if (eodPrice.allFieldsEqual()) {
            // Only serialize if all fields are equal
            writer.serializeAsField(pojo, jgen, provider);
        }
    }

    @Override
    protected boolean include(BeanPropertyWriter writer) {
        return true;
    }

    @Override
    protected boolean include(PropertyWriter writer) {
        return true;
    }
};