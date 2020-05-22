public class MyCustomSerializer extends SerializerBase<ClassToBeSerialized> {

    public MyCustomSerializer() {
        super(ClassToBeSerialized.class);
    }

    @Override
    public void serialize(ClassToBeSerialized yourClass,
                          JsonGenerator jsonGenerator,
                          SerializerProvider serializerProvider) throws IOException, JsonGenerationException {
        jsonGenerator.writeStartObject();
        try {
            jsonGenerator.writeFieldName("big (" + yourClass.getLocale().toString() + ")");
            jsonGenerator.writeString(getLocaleSpecificSerializedValue(yourClass.getBig(), yourClass.getLocale()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        jsonGenerator.writeEndObject();
    }

    private String getLocaleSpecificSerializedValue(BigDecimal big, Locale locale) throws ParseException {
        NumberFormat nf = NumberFormat.getInstance(locale);
        return nf.parse(big.toString()).toString();
    }
}