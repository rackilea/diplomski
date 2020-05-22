import org.json.JSONArray;
import org.json.JSONObject;

public class OrgJsonApp {
  public static void main(String[] args) {
      JSONObject root = new JSONObject();
      root.put("name", "timmy");
      root.put("age", "20");


      JSONObject ids = new JSONObject();
      ids.put("jobId", "123");
      ids.put("houseId", "5");

      JSONArray idList = new JSONArray();
      idList.put(ids);

      root.put("idList", idList);

      System.out.println(root.toString(4));
  }
}