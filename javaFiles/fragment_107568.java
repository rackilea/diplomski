import java.lang.reflect.Type;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
...  

Type type = new TypeToken<Map<String, Object>>() {}.getType();
Map<String, Object> data = new Gson().fromJson(jsonString, type);

for (Iterator<Map.Entry<String, Object>> it = data.entrySet().iterator(); it.hasNext();) {
    Map.Entry<String, Object> entry = it.next();
    if (entry.getValue() == null) {
        it.remove();
    } else if (entry.getValue().getClass().equals(ArrayList.class)) {
        if (((ArrayList<?>) entry.getValue()).size() == 0) {
            it.remove();
        }
    }
}

String json = new GsonBuilder().setPrettyPrinting().create().toJson(data);
System.out.println(json);