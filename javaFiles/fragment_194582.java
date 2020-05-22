import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;

JsonElement yourJson = mapping.get("servers");
Type listType = new TypeToken<List<String>>() {}.getType();

List<String> yourList = new Gson().fromJson(yourJson, listType);