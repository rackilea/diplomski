import org.json.*;

JSONObject o = new JSONObject(jsonString);
JSONArray arr = obj.getJSONArray("Attendance");
for (int i = 0; i < arr.length(); i++)
{
   JSONObject b = arr.getJSONObject(i);
   Iterator<?> keys = b.keys();    
   while( keys.hasNext() ) {
       String key = (String)keys.next();
       System.out.println(key+": "+b.get(key).toString());   

   }

}