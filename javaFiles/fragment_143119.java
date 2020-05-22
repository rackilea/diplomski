public class StandardSerializer implements JsonSerializer<Standard>{

    @Override
    public JsonElement serialize(Standard src, Type typeOfSrc,
            JsonSerializationContext context) {

            JsonObject obj = new JsonObject();
            //You put your simple objects in like this
            obj.add("id",new JsonPrimitive(src.getId()));
            //You put your complex objects in like this
            JsonObject interpretations = new JsonObject();
            //Here you need to parse your LinkedHashSet object and set up the values. 
            //For the sake of simplicity I just access the properties (even though I know this would not compile)
            interpretations.add("title", src.getInterpretation().getTitle());
            obj.add("interpretations", interpretations);
            return obj;
        }

}