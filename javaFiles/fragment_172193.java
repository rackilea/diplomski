import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

String jsonStr = "{\"m\":{\"p\":{\"0\":{\"ms\":{\"s\":1}}}}}";
Gson gson = new GsonBuilder().create();
Map data = gson.fromJson(jsonStr, Map.class);
Object value = obj.get(data, "s");
System.out.println(value); //1.0

//Input JSON as Map & key to search on
public Object get(Map data, String key) {
    System.out.println(data);
    if (!data.containsKey(key)) {
        for (Object v : data.values()) {
            return get((Map) v, key);
        }
    }
    return data.get(key);
}