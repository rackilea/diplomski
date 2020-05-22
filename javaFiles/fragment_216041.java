class MyObjectAdapter implements JsonDeserializer<MyObject> {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private static final Type listSequenceType = new TypeToken<List<Sequence>>(){}.getType();

    public MyObject deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        List<DateMapping> dateMappings = new ArrayList<>();
        for(Map.Entry<String, JsonElement> entry : json.getAsJsonObject().entrySet()) {
            try {
                dateMappings.add(new DateMapping(dateFormat.parse(entry.getKey()), context.deserialize(entry.getValue(), listSequenceType)));
            } catch (ParseException e) {
                e.printStackTrace();
                throw new RuntimeException("Can't parse the date");
            }
        }
        return new MyObject(dateMappings);
    }
}