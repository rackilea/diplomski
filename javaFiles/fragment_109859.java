import com.google.gson.Gson;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class GsonApp {

    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();
        map.put("FirstName", Collections.singletonList(new Type("url/FirstName", "Rick")));
        map.put("LastName", Collections.singletonList(new Type("url/LastName", "Pickle")));

        Attributes attributes = new Attributes();
        attributes.setAttributes(map);

        String json = new Gson().newBuilder().setPrettyPrinting().create().toJson(attributes);
        System.out.println(json);
    }
}