import org.json.JSONException;
import org.json.JSONObject;

public static Object getValue(String data, String key) throws JSONException {
      JSONObject jObject = new JSONObject(data);
       return jObject.get(key);
}


String visitorID = (String) getValue(runtimeData, "VisitorID");
System.out.println(visitorID);