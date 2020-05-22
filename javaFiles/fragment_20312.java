public class CustomJsonTimeDeserializerWithoutTimeZone extends JsonDeserializer<Time>{

    @Override
    public Time deserialize(JsonParser jp, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {
        DateFormat format = new SimpleDateFormat("hh:mm:ss.SSS");
        Time time = null;
        try{
            Date dt = format.parse("10:30:00.000-05.00".substring(0,12)); // remove incorrect timezone format
            return new Time(dt.getTime());
        }catch (ParseException e){
            e.printStackTrace();
        }
    }

}