import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public static String toJson(List<Item> items){

    try{

        JSONObject jsonObj = new JSONObject();

        JSONArray jsonArr = new JSONArray();

        for(Item i : items){
            JSONObject itemObj = new JSONObject();
            itemObj.put("names", i.getName());
            itemObj.put("companies", i.getCompanies());
            itemObj.put("colors", i.getColors());
            itemObj.put("numbers", i.getNumbers());
            itemObj.put("candy", i.getCandy());
            jsonArr.put(itemObj);
        }

        jsonObj.put("items", jsonArr);

        return jsonObj.toString();

    } catch(JSONException ex){
         ex.printStackTrace();
    }

    return null;
}