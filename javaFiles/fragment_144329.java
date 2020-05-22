public class MyJsonDeserializer implements JsonDeserializer<YourParsedData> {

   @Override 
   public YourParsedData deserialize(final JsonElement je, final Type type, final JsonDeserialization Context jdc) throws JsonParseException
   {
      final JsonObject obj = je.getAsJsonObject(); //our original full json string
      final JsonElement serviceElement = obj.get("service");


     //here we provide the functionality to handle the naughty element. It seems emtpy string is returned as a JsonPrimitive... so one option
     if(serviceElement instanceOf JsonPrimitive)
     {
       //it was empty do something
     }

     return YourParsedData.create(); //provide the functionality to take in the parsed data
   }
 }