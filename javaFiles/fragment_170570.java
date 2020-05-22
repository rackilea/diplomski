class DateDeserializer implements JsonDeserializer<Date>
{
    @Override
    public Date deserialize(JsonElement je, Type type, JsonDeserializationContext jdc) throws JsonParseException
    {
        String myDate = je.getAsString();
        // inspect string using regexes
        // convert string to Date        
        // return Date object
    }

}