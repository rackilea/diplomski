import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
...
public void stuff()
    {
        List<String> data = new ArrayList<String>();
        data.add("");
        data.add("abc");
        data.add("IF(Var218 = \"charlie\") AND (Var85 &le; 0) AND (Var207 = \"some value\"; \"du\") THEN Appetency = 1 ");
        data.add("\"\"");

        Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();

        JsonObject test = new JsonObject();
        JsonElement jsonData = gson.toJsonTree(data, new TypeToken<List<String>>(){}.getType());
        test.add("test", jsonData);

        String json = gson.toJson(test);
        System.out.println(json);
    }