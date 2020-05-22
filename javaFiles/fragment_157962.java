import java.lang.reflect.Type;
import com.google.gson.*;

public class PersistentObjectJsonSerializer implements JsonSerializer<PersistentObject> {
    @Override
    public JsonElement serialize(PersistentObject persistentObject, Type typeOfSrc, JsonSerializationContext context) {
        persistentObject.DT_RowId = persistentObject.id;
        Gson gson = new Gson();
        return gson.toJsonTree(persistentObject);
    }
}