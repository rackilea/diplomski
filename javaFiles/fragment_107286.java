import org.json.JSONArray;
import org.json.JSONException;


public class JsonTest {

/**
 * @param args
 * @throws JSONException 
 */
public static void main(String[] args) throws JSONException {
    String resJson  = "[{\r\n" + 
            "    \"0\": \"1\",\r\n" + 
            "    \"id\": \"1\",\r\n" + 
            "    \"1\": null,\r\n" + 
            "    \"name\": null,\r\n" + 
            "    \"2\": \"tim\",\r\n" + 
            "    \"username\": \"tim\",\r\n" + 
            "    \"3\": \"tim@billstrom.me\",\r\n" + 
            "    \"email_address\": \"tim@billstrom.me\",\r\n" + 
            "    \"4\": \"http:\\/\\/graph.facebook.com\\/timbillstrom\\/picture?width=500&height=500\",\r\n" + 
            "    \"img\": \"http:\\/\\/graph.facebook.com\\/timbillstrom\\/picture?width=500&height=500\"\r\n" + 
            "}]";

    JSONArray Jarray = new JSONArray(resJson);
    String Jobject = Jarray.getJSONObject(0).getString("img");

    System.out.println(Jobject);
}
}