import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

 public List<element> generateList()
 { 
  String jsonString = "[{\"id\": 1,\"name\": \"water\"},{\"id\": 2,\"name\": \"fire\"}]"; 
  JSONArray json = null;
  List<element> mElementList = new ArrayList<element>();
    try {
        json = new JSONArray(jsonString);
    } catch (JSONException je) {
        Log.e("TAG", "Json Exception" + je.getMessage() );
        return;
    }
 JSONObject jsonObject = null;
    element ele = null;
    for (int i = 0; i < json.length(); i++) {
        try {
            jsonObject = json.getJSONObject(i);
                            ele = new element();

                            if(jsonObject.has("id"))
                             {
                               ele.id = jsonObject.getString("id")
                             }     

                            if(jsonObject.has("name"))
                             {
                               ele.name = jsonObject.getString("name")
                             }     

            mElementList.add(ele);
        } catch (JSONException jee) {
            Log.e("TAG", "" + jee.getMessage());
        }

    }
           return mElementList;
   }