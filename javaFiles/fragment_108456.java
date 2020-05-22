@Override
public LocalDate deserialize(JsonParser jp, DeserializationContext ctxt)
    throws IOException, JsonProcessingException
{
    // [yyyy,mm,dd]
    if (jp.isExpectedStartArrayToken()) {
        jp.nextToken(); // VALUE_NUMBER_INT 
        int year = jp.getIntValue(); 
        jp.nextToken(); // VALUE_NUMBER_INT
        int month = jp.getIntValue();
        jp.nextToken(); // VALUE_NUMBER_INT
        int day = jp.getIntValue();
        if (jp.nextToken() != JsonToken.END_ARRAY) {
            throw ctxt.wrongTokenException(jp, JsonToken.END_ARRAY, "after LocalDate ints");
        }
        return new LocalDate(year, month, day);
    }
    switch (jp.getCurrentToken()) {
    case VALUE_NUMBER_INT:
        return new LocalDate(jp.getLongValue());            
    case VALUE_STRING:
        String str = jp.getText().trim();
        if (str.length() == 0) { // [JACKSON-360]
            return null;
        }
        return parser.parseLocalDate(str);
    default:
    }
    throw ctxt.wrongTokenException(jp, JsonToken.START_ARRAY, "expected JSON Array, String or Number");
}