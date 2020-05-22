import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
public class CodeChefTest1 {
    public static String json = "{\"balance\": 1000.21, \"num\":100, \"is_vip\":true, \"name\":\"foo\"}";
    public static void main(String[] args) {
        JsonElement ele = new JsonParser().parse(json);
        for(java.util.Map.Entry<String, JsonElement> entr : ele.getAsJsonObject().entrySet()){
            System.out.println(entr.getKey());
            System.out.println(entr.getValue());
        }
    }
}