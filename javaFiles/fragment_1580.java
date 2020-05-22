import org.json.JSONException;
import org.json.JSONObject;

public class JsonTest {
    public static void main(String[] args) {
        try {
            JSONObject testObject = new JSONObject("{\"a\":\"vala\", \"b\":\"valb\", \"c\":\"valc\"}");
            testObject.remove("b");
            testObject.remove("c");
            System.out.println(testObject.toString());  // This prints out the json string
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}