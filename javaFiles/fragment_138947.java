import org.json.JSONArray;

public class JsonTest {

    public static void main(String[] args) throws Exception {
        String json = "[\"9784142605765949528\",2869,264,7]";
        JSONArray result = new JSONArray(json);
        System.out.println(result);
    }
}