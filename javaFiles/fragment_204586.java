import org.json.JSONArray;
import org.json.JSONException;

public class jsonArray {
    public static void main(String[] args) {
        String text = "[{\"location\":\"Boston\"},{\"value\":\"5\"},{\"coverage\":\"15\"},{\"validPeriod\":\"08/05/2013\"},{\"description\":\"test description\"}]";

        try {
            JSONArray jsonArray = new JSONArray(text);
            System.out.println(jsonArray.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}