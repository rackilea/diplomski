public class CustomDateJsonSerializer implements JsonSerializer<Date>, JsonDeserializer<Date> {
    private static final TimeZone UTC_TIME_ZONE = TimeZone.getTimeZone("UTC");
    private static final Pattern DATE_PATTERN = Pattern.compile("\\d{4}-\\d{2}-\\d{2}");
    private static final Pattern DATE_TIME_PATTERN = Pattern.compile("\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}");

    public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        String asString = json.getAsString();
        try {
            if (DATE_PATTERN.matcher(asString).matches()) {
                return getDateFormat().parse(asString);
            } else if (DATE_TIME_PATTERN.matcher(asString).matches()) {
                return getDateTimeFormat().parse(asString);
            } else {
                throw new JsonParseException("Could not parse to date: " + json);
            }
        } catch (ParseException e) {
            throw new JsonParseException("Could not parse to date: " + json, e);
        }
    }

    private static DateFormat getDateFormat() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd");
        simpleDateFormat.setTimeZone(UTC_TIME_ZONE);
        return simpleDateFormat;
    }

    private static DateFormat getDateTimeFormat() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        dateFormat.setTimeZone(UTC_TIME_ZONE);
        return dateFormat;
    }

    public JsonElement serialize(Date date, Type typeOfSrc, JsonSerializationContext context) {
        Calendar calendar = Calendar.getInstance(UTC_TIME_ZONE);
        calendar.setTime(date);
        int hours = calendar.get(Calendar.HOUR);
        int minutes = calendar.get(Calendar.MINUTE);
        int seconds = calendar.get(Calendar.SECOND);
        String dateFormatted;
        if (hours == 0 && minutes == 0 && seconds == 0) {
            dateFormatted = getDateFormat().format(date);
        } else {
            dateFormatted = getDateTimeFormat().format(date);
        }
        return new JsonPrimitive(dateFormatted);
    }
}