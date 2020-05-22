private static SimpleDateFormat dateFormatWithoutTimezome = new SimpleDateFormat("yyyy-MM-dd");
private static SimpleDateFormat dateFormatWithTimezone= new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ"); 
private static Pattern pattern = Pattern.compile("([0-9]{4})-([0-9]{2})-([0-9]{2})");

@Override
public Date deserialize(JsonParser jparser, DeserializationContext ctxt) throws IOException, JsonProcessingException {
    String content = jparser.getValueAsString();
    DateFormat format=(pattern.matcher(content).matches()) ? dateFormatWithoutTimezome : dateFormatWithTimezone;        

try {
    return format.parse(content);
} catch (ParseException e) {
    throw new JsonParseException("Date parse failed", jparser.getCurrentLocation(),e);
}
}