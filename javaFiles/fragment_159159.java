import org.json.*;

JSONParser JSON = new JSONParser();
JSONObject obj = JSON.parse(line);

String hr0 = obj.getJSONObject("0")
        .getJSONObject("Identification")
        .getString("health_regen");