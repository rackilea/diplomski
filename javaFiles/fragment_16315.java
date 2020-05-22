new JsonDeserializer<Date>() {
    private SimpleDateFormat dtf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    {
        // Indicate the time zone of the input date
        dtf.setTimeZone(TimeZone.getTimeZone("Asia/Dubai"));
    }
    @Override
    public Date deserialize(JsonElement json, Type type, 
        JsonDeserializationContext deserializationContext) throws JsonParseException {
        try {
            // Get the json element as a String and parse it to get a Date
            return dtf.parse(json.getAsString());
        } catch (ParseException e) {
            // Throw a JsonParseException in case of a parsing error
            throw new JsonParseException(e);
        }
    }
}