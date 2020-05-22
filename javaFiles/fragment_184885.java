public class HumanSerializer implements JsonSerializer<Human> {

 @Override
public JsonElement serialize(final Human human, final Type type, final JsonSerializationContext context) {
             final JsonObject json = new JsonObject();
             if(human instanceof Human)
                 json.addProperty("type", "Human");
             if(human instanceof Worker)
                 json.addProperty("type", "Worker");
             if(human instanceof Student)
                 json.addProperty("type", "Student");

         json.addProperty("name", human.getName());
        return json;
    }
}