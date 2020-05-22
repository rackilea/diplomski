public class LocalTimeSerializer implements JsonDeserializer<LocalTime>, JsonSerializer<LocalTime>
{

   private static final DateTimeFormatter TIME_FORMAT = ISODateTimeFormat.timeNoMillis();

   @Override
   public LocalTime deserialize(final JsonElement je, final Type type,
                           final JsonDeserializationContext jdc) throws JsonParseException
   {
      final String dateAsString = je.getAsString();
      if (dateAsString.length() == 0)
      {
         return null;
      }
      else
      {
         return TIME_FORMAT.parseLocalTime(dateAsString);         
      }
   }

   @Override
   public JsonElement serialize(final LocalTime src, final Type typeOfSrc,
                                final JsonSerializationContext context)
   {
      String retVal;
      if (src == null)
      {
         retVal = "";
      }
      else
      {
         retVal = TIME_FORMAT.print(src);
      }
      return new JsonPrimitive(retVal);
   }

}