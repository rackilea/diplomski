new GsonBuilder().registerTypeAdapter(Date.class, new DateDeserializer());

private static final String[] DATE_FORMATS = new String[] {
        "MMM dd, yyyy HH:mm:ss",
        "MMM dd, yyyy"
};


private class DateDeserializer implements JsonDeserializer<Date> {

    @Override
    public Date deserialize(JsonElement jsonElement, Type typeOF,
            JsonDeserializationContext context) throws JsonParseException {
        for (String format : DATE_FORMATS) {
            try {
                return new SimpleDateFormat(format, Locale.US).parse(jsonElement.getAsString());
            } catch (ParseException e) {
            }
        }
        throw new JsonParseException("Unparseable date: \"" + jsonElement.getAsString()
                + "\". Supported formats: " + Arrays.toString(DATE_FORMATS));
    }
}