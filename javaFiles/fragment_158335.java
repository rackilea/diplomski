package json;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class MyApp {
    static List<String> list = new ArrayList<String>();
    public static void main(String[] args) {

        String key = "oauthSecret";

        String json2 = "{\"config\": {\"oauthSecret\": [{\"id\": 45,\"config123\": {\"oauthSecret\": \"P8n2x5Ht0nFRRB0A\",\"status\": \"CREATED\"},\"SERVER132\": \"1000\"},{\"id\": 46,\"config123\": {\"oauthSecret\": \"wP8n2x5Ht0nFRRB0A\",\"status\": \"CREATED\"},\"SERVER132\": \"1000\"}],\"oauthKey\": \"newtest\",\"SERVER\": \"1000\"},\"features\": [ 9004, 9005] ,\"d\":\"dd\"}";

        System.out.println("JSON: " + json2);
        JsonParser p = new JsonParser();
        check(key, p.parse(json2));
        System.out.println("list size: " + list.size());
        System.out.println(list);
    }



    private static void check(String key, JsonElement jsonElement) {

        if (jsonElement.isJsonArray()) {
            for (JsonElement jsonElement1 : jsonElement.getAsJsonArray()) {
                check(key, jsonElement1);
            }
        } else {
            if (jsonElement.isJsonObject()) {
                Set<Map.Entry<String, JsonElement>> entrySet = jsonElement
                        .getAsJsonObject().entrySet();
                for (Map.Entry<String, JsonElement> entry : entrySet) {
                    String key1 = entry.getKey();
                    if (key1.equals(key)) {
                        list.add(entry.getValue().toString());
                    }
                    check(key, entry.getValue());
                }
            } else {
                if (jsonElement.toString().equals(key)) {
                    list.add(jsonElement.toString());
                }
            }
        }
    }

}