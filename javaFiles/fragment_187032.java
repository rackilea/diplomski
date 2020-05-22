public class FooBarAdapter implements JsonSerializer<Bar> {

   @Override
   public JsonElement serialize(Bar bar, Type typeOfObj,
        JsonSerializationContext context)
   {

       JsonObject obj = new JsonObject();
       obj.addProperty("foo", bar.foo.id);
       obj.addProperty("data", bar.data);

       return obj;
   }

}