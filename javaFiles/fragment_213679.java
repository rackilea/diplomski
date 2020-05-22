import java.lang.reflect.Type;
import com.google.gson.*;

public class EntityJsonSerializer implements JsonSerializer<Entity> {
    @Override
    public JsonElement serialize(Entity entity, Type typeOfSrc, JsonSerializationContext context) {
       entity.DT_RowId = entity.id;
       Gson gson = new Gson();
       return gson.toJsonTree(entity);
    }
}