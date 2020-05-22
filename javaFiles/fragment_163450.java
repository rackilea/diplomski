class DateSerializer extends JsonSerializer<Date> implements ContextualSerializer {
    private boolean doCustom;

    DateSerializer() {}

    private DateSerializer(boolean doCustom) { this.doCustom = doCustom; }

    @Override
    public void serialize(Date value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        if (doCustom) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String date = sdf.format(value);
            gen.writeString(date);
        } else {
            provider.defaultSerializeDateValue(value, gen);
        }
    }

    @Override
    public JsonSerializer<Date> createContextual(SerializerProvider config, BeanProperty property) {
        boolean doCustom = property == null || !"dateToBeDefaultSerialized".equals(property.getName());
        return new DateSerializer(doCustom);
    }
}