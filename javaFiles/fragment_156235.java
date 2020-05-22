import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Test {
    public static void main(String[] args) throws JSONException {
        JSONObject leaf = new JSONObject().put("name", "500 ML");
        JSONObject lemon = new JSONObject().put("name", "Lemon").put("leaf", new JSONArray().put(leaf));
        JSONObject orange = new JSONObject().put("name", "Orange").put("leaf", new JSONArray().put(leaf));
        JSONArray t3Array = new JSONArray().put(lemon).put(orange);
        JSONObject bottled = new JSONObject().put("name", "Bottled").put("T3", t3Array);
        JSONObject fountain = new JSONObject().put("name", "Fountain").put("T3", t3Array);
        JSONObject softDrink = new JSONObject().put("T2", new JSONArray().put(bottled).put(fountain));
        JSONObject json = new JSONObject().put("Soft Drinks", softDrink);

        System.out.println(json);
    }
}