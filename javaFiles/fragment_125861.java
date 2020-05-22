import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

public class GsonApp {

    public static void main(String[] args) throws Exception {
        File jsonFile = new File("./resource/test.json").getAbsoluteFile();

        final Gson gson = new Gson();
        final Type map = new TypeToken<Map<String, Map<String, List<String>>>>(){}.getType();
        final Map<String, Map<String, List<String>>> result = gson.fromJson(new FileReader(jsonFile), map);
        System.out.println(result);

        if (result != null) {
            for (final Map.Entry<String, Map<String, List<String>>> entry : result.entrySet()) {
                System.out.println("username: " + entry.getKey());
                final Map<String, List<String>> user = entry.getValue();
                System.out.println("transactions: " + user);
            }
        }
    }
}