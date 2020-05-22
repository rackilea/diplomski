import org.json.JSONException;
import org.json.JSONObject;
public static void main(String[] args) {
        String jsonString = "{\"files\": {\"f1.png\": {\"intext\": \"A\",\"inval\": 0,\"inbinary\": false}, \"f2.png\": {\"intext\": \"A\",\"inval\": 0,\"inbinary\": true}}}";
        try {
            JSONObject jsonObject =new JSONObject(jsonString);
            JSONObject jsonChildObject = (JSONObject)jsonObject.get("files");
            Iterator iterator  = jsonChildObject.keys();
            String key = null;
            while(iterator.hasNext()){
                key = (String)iterator.next();
                System.out.println("inval value: "+((JSONObject)jsonChildObject.get(key)).get("inval"));
            }
        }
        catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }