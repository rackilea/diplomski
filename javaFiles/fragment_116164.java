public class PersonDeserializer extends JsonDeserializer<List<Person>>
{
   @Override
   public List<Person> deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException
   {
      List<Person> retVal = new ArrayList<Person>();
      if (jp.getCurrentToken() == JsonToken.START_OBJECT)
      {
         retVal.add(jp.readValueAs(Person.class));
      }
      else if (jp.getCurrentToken() == JsonToken.START_ARRAY)
      {
         while (jp.nextToken() == JsonToken.START_OBJECT)
         {
            retVal.add(jp.readValueAs(Person.class));
         }
      }

      return retVal;
   }
}