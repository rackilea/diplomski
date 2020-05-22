import java.io.*;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;
import com.google.gson.*;

public class ChampionSearch {
    public static void main(String[] args) {
        InputStream stream = ChampionSearch.class.getClassLoader().getResourceAsStream("champion.json");
        InputStreamReader reader = new InputStreamReader(stream);
        JsonObject json = JsonParser.parseReader(reader).getAsJsonObject();
        Entry<String, JsonElement> found = findFirst(json, "key", "266");
        System.out.printf("Found: %s%n", getValueForKey(found.getValue(), "id"));
    }

    public static String getValueForKey(JsonElement data, String key) {
        return data.getAsJsonObject().get(key).getAsString();
    }

    public static Entry<String, JsonElement> findFirst(JsonObject json, String key, String value) {
        return findAll(json, key, value).iterator().next();
    }

    public static Set<Entry<String, JsonElement>> findAll(JsonObject json, String key, String value) {
        return json.getAsJsonObject("data").entrySet().stream().filter(entry -> {
            return entry.getValue().getAsJsonObject().get(key).getAsString().equals(value);
        }).collect(Collectors.toSet());
    }
}