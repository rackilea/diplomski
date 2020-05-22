import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        String json = "[{\n" +
                "   \"zip\":544,\n" +
                "   \"type\":\"UNIQUE\",\n" +
                "   \"primary_city\":\"Holtsville\",\n" +
                "   \"acceptable_cities\":\"\",\n" +
                "   \"unacceptable_cities\":\"Irs Service Center\",\n" +
                "   \"state\":\"NY\",\n" +
                "   \"county\":\"Suffolk County\",\n" +
                "   \"timezone\":\"America/New_York\",\n" +
                "   \"area_codes\":\"631\",\n" +
                "   \"latitude\":40.81,\n" +
                "   \"longitude\":-73.04,\n" +
                "   \"world_region\":\"NA\",\n" +
                "   \"country\":\"US\",\n" +
                "   \"decommissioned\":0,\n" +
                "   \"estimated_population\":0,\n" +
                "   \"notes\":\"\"\n" +
                " },\n" +
                " {\n" +
                "   \"zip\":601,\n" +
                "   \"type\":\"STANDARD\",\n" +
                "   \"primary_city\":\"Adjuntas\",\n" +
                "   \"acceptable_cities\":\"\",\n" +
                "   \"unacceptable_cities\":\"Colinas Del Gigante, Jard De Adjuntas, Urb San Joaquin\",\n" +
                "   \"state\":\"PR\",\n" +
                "   \"county\":\"Adjuntas\",\n" +
                "   \"timezone\":\"America/Puerto_Rico\",\n" +
                "   \"area_codes\":\"787,939\",\n" +
                "   \"latitude\":18.16,\n" +
                "   \"longitude\":-66.72,\n" +
                "   \"world_region\":\"NA\",\n" +
                "   \"country\":\"US\",\n" +
                "   \"decommissioned\":0,\n" +
                "   \"estimated_population\":0,\n" +
                "   \"notes\":\"\"\n" +
                " }]";
        Map<Integer, JSONObject> map = new HashMap<>();
        JSONArray array = new JSONArray(json);
        for (int i = 0; i < array.length(); i++) {
            JSONObject jsonObject = array.getJSONObject(i);
            map.put(jsonObject.getInt("zip"), jsonObject);
        }


    }
}