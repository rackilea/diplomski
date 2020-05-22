private static final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss";
    private static final String TIME_FORMAT = "HH:mm:ss";

    private class DateDeserializer implements JsonDeserializer<Date> {

        @Override
        public Date deserialize(JsonElement jsonElement, Type typeOF,
                                JsonDeserializationContext context) throws JsonParseException {
                try {
                    return new SimpleDateFormat(DATE_FORMAT, Locale.US).parse(jsonElement.getAsString());
                } catch (ParseException e) {
                }

            throw new JsonParseException("Unparseable date: \"" + jsonElement.getAsString()
                    + "\". Supported formats: " + DATE_FORMAT);
        }
    }

    private class TimeDeserializer implements JsonDeserializer<Time> {

        @Override
        public Time deserialize(JsonElement jsonElement, Type typeOF,
                                JsonDeserializationContext context) throws JsonParseException {
                try {

                    String s = jsonElement.getAsString();
                    SimpleDateFormat sdf = new SimpleDateFormat(TIME_FORMAT, Locale.US);
                    sdf.parse(s);
                    long ms = sdf.parse(s).getTime();
                    Time t = new Time(ms);
                    return t;
                } catch (ParseException e) {
                }
            throw new JsonParseException("Unparseable time: \"" + jsonElement.getAsString()
                    + "\". Supported formats: " + TIME_FORMAT);
        }
    }