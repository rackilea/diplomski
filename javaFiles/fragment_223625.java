import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;

import java.io.File;

public class JsonPathApp {

    public static void main(String[] args) throws Exception {
        File jsonFile = new File("./resource/test.json").getAbsoluteFile();

        JSONArray filtered = JsonPath.parse(jsonFile).read("$.tags[?(@.data[0].v != null)]");

        // Create root object
        JSONObject root = new JSONObject();
        root.appendField("tags", filtered);

        // Get JSON
        String json = root.toString();

        // Write JSON on console or file
        System.out.println(json);
    }
}