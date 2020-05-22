import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.*;

public class JsonMapConverter {

public static void main(String... x) throws Exception {

    String jsonString = "{\"2016\":{\"12\":{\"20\":{\"19\":{\"DonationTime\":11111111111,\"Donation\":10}}}}}";
    JSONObject json  = new JSONObject(jsonString);
    Map<String,Object> yearMap = toMap(json);

    String year =  yearMap.keySet().iterator().next();
    Map<String,Object> monthMap = ((Map<String, Object>) yearMap.get(year));

    String month = monthMap.keySet().iterator().next();
    Map<String,Object> dayMap = (Map<String, Object>) monthMap.get(month);

    String day = dayMap.keySet().iterator().next();
    Map<String,Object> hourMap = (Map<String, Object>) dayMap.get(day);

    System.out.println(yearMap);
    System.out.println(monthMap);
    System.out.println(dayMap);
    System.out.println(hourMap);
}

public static Map<String, Object> toMap(JSONObject object) throws JSONException {
    Map<String, Object> map = new HashMap<String, Object>();

    Iterator<String> keysItr = object.keys();
    while(keysItr.hasNext()) {
        String key = keysItr.next();
        Object value = object.get(key);

        if(value instanceof JSONArray) {
            value = toList((JSONArray) value);
        }

        else if(value instanceof JSONObject) {
            value = toMap((JSONObject) value);
        }
        map.put(key, value);
    }
    return map;
}

public static List<Object> toList(JSONArray array) throws JSONException {
    List<Object> list = new ArrayList<Object>();
    for(int i = 0; i < array.length(); i++) {
        Object value = array.get(i);
        if(value instanceof JSONArray) {
            value = toList((JSONArray) value);
        }

        else if(value instanceof JSONObject) {
            value = toMap((JSONObject) value);
        }
        list.add(value);
    }
    return list;
  }
}