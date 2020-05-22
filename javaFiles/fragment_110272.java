import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

...

        JSONObject obj = new JSONObject();
        JSONArray list = new JSONArray();

        list.put("guest_login");
        try {
            list.put(new JSONObject().put("chips", new JSONObject().put("1", "2000")));
            list.put(obj.put("epoch", "1552509677"));
        } catch (JSONException e) {
            e.printStackTrace();
        }