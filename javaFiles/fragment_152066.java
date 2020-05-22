import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;
public class TestJson {
    public static void parseProfilesJson(String jsonStr) {
        try {
            JSONArray nameArray = (JSONArray) JSONSerializer.toJSON(jsonStr);
            System.out.println(nameArray.size());
            for(Object js : nameArray){
                JSONObject json = (JSONObject) js;
                System.out.println(json.get("date"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        String s = "[{\"date\":\"2012-04-23\",\"activity\":\"gym\"},{\"date\":\"2012-04-24\",\"activity\":\"walking\"}]";
        parseProfilesJson(s);
    }
}