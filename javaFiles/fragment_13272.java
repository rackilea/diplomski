import org.json.JSONArray;
import org.json.JSONObject;

public class Test {

  public static void main(String... args) {
    String json = "[\r\n" + 
        "  {\r\n" + 
        "    \"_id\": {\r\n" + 
        "      \"$oid\": \"57833bf8cb3099a383e8e2af\"\r\n" + 
        "    },\r\n" + 
        "    \"Name\": \"3GBWS\",\r\n" + 
        "    \"Version\": \"QV3.2\",\r\n" + 
        "    \"Type\": \"FQGA\",\r\n" + 
        "    \"SerialNO\": \"L1D73708884\",\r\n" + 
        "    \"Location\": \"TEXAS\"\r\n" + 
        "  },\r\n" + 
        "  {\r\n" + 
        "    \"_id\": {\r\n" + 
        "      \"$oid\": \"5784818bcb30b4918964b50f\"\r\n" + 
        "    },\r\n" + 
        "    \"Name\": \"3GBTW\",\r\n" + 
        "    \"Version\": \"WN6.0\",\r\n" + 
        "    \"Type\": \"FQGW\",\r\n" + 
        "    \"SerialNO\": \"O1143734584\",\r\n" + 
        "    \"Location\": \"OHIO\"\r\n" + 
        "  },\r\n" + 
        "  {\r\n" + 
        "    \"_id\": {\r\n" + 
        "      \"$oid\": \"5784818bcb30b4918964b50f\"\r\n" + 
        "    },\r\n" + 
        "    \"Name\": \"TEXAS\",\r\n" + 
        "    \"Version\": \"AS1.0\",\r\n" + 
        "    \"Type\": \"FWQA\",\r\n" + 
        "    \"SerialNO\": \"DH783708884\",\r\n" + 
        "    \"Location\": \"NY\"\r\n" + 
        "  },\r\n" + 
        "  {\r\n" + 
        "    \"_id\": {\r\n" + 
        "      \"$oid\": \"5784818bcb30b4918964b50f\"\r\n" + 
        "    },\r\n" + 
        "    \"Name\": \"3GLTS\",\r\n" + 
        "    \"Version\": \"WE9.0\",\r\n" + 
        "    \"Type\": \"FQGW\",\r\n" + 
        "    \"SerialNO\": \"L0943708884\",\r\n" + 
        "    \"Location\": \"TEXAS\"\r\n" + 
        "  }\r\n" + 
        "]";
    JSONArray array = new JSONArray(json);
    int count = 0;
    for(int i = 0; i < array.length(); i++) {
      JSONObject element = array.getJSONObject(i);
      String location = element.getString("Location");
      if(location.equals("TEXAS")) {
        count ++;
      }
    }
    System.out.println("TEXAS=" + count);
  }
}