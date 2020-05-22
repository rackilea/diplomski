import java.io.FileReader;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author blj0011
 */
public class JsonSimpleReaderExample
{
    public static void main(String[] args)
    {
        JSONParser parser = new JSONParser();

        try {
            Object obj = parser.parse(new FileReader("file.json"));
            JSONObject jsonObject = (JSONObject) obj;

            JSONArray array = (JSONArray) jsonObject.get("data");
            Iterator<JSONObject> iterator = array.iterator();
            while (iterator.hasNext()) {
                JSONObject jsonObjectInJsonArray = (JSONObject) iterator.next();
                System.out.println(jsonObjectInJsonArray.get("host"));
            }
        }
        catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }
}