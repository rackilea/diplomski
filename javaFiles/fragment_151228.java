import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class JsonPathTest {

    public static String ROOT_ARRAY = "issues";
    public static String KEY = "key";
    // get all KEYs right under ROOT array
    public static String jsonPath = String.format("$.%s[*].%s", ROOT_ARRAY, KEY);

    public static void main(String[] args) {
        try {
            String jsonStr = new String(Files.readAllBytes(Paths.get("c:/temp/xx.json")));
            Object jsonObj = Configuration.defaultConfiguration().jsonProvider().parse(jsonStr);
            List<String> keys = JsonPath.parse(jsonObj).read(jsonPath);
            System.out.println(keys);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}