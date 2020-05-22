import org.json.JSONException;
import org.json.JSONObject;


public class Main { 
public static void main(String[] args) throws JSONException  {

    String str = "{" + 
            "    \"result\": {" + 
            "        \"name1\": \"value1\"," + 
            "        \"name2\": \"value2\"," + 
            "    }," + 
            "    \"wantedName\": \"wantedValue\"" + 
            "}";

    JSONObject jsonObject = new JSONObject(str);

    System.out.println(jsonObject.getString("wantedName"));
}