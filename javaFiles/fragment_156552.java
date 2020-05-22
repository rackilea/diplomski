import org.json.JSONArray;
import org.json.JSONObject;

public class Test {

public static void main(String[] args) {
    String str = "{\"routes\":[{\"bounds\":{\"northeast\":{\"lat\":19.0759817,\"lng\":80.27071789999999},\"southwest\":{\"lat\":12.5100381,\"lng\":72.8776544}},\"copyrights\":\"Map data ©2015 Google\",\"legs\":[{\"distance\":{\"text\":\"1,334 km\",\"value\":1333618},\"duration\":{\"text\":\"17 hours 43 mins\",\"value\":63762},\"end_address\":\"Mumbai, Maharashtra, India\",\"end_location\":{\"lat\":19.0759817,\"lng\":72.8776544},\"start_address\":\"Chennai, Tamil Nadu, India\",\"start_location\":{\"lat\":13.0826782,\"lng\":80.27071789999999}}]}]}";
    JSONObject reader = new JSONObject(str);
    JSONArray one = reader.getJSONArray("routes");

    for (int i = 0; i < one.length(); i++) {

      JSONObject two = one.getJSONObject(i);

      JSONArray three = two.getJSONArray("legs");
      for (int j = 0; j < three.length(); j++) {

        JSONObject four = three.getJSONObject(j);
        JSONObject five = four.getJSONObject("distance");
        String str_long_name=five.getString("text");
        System.out.println(str_long_name);

          }

    }
}
}