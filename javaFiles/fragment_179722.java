java.util.Map<String , Object> myMap = new java.util.HashMap<>();

for (int i = 0; i < arr.length(); i++) {
        String opened_at = arr.getJSONObject(i).getString("opened_at");
        String sys_updated_by = arr.getJSONObject(i).getString("sys_updated_by");
        String state = arr.getJSONObject(i).getString("state");

        // your CATCH
        myMap.put( sys_updated_by , arr.getJSONObject(i) ); 
    }

// IF YOUR ARE HARDCODING ACCESS
try
{
     System.out.println( ( (JSONObject)myMap.get("user") ).getString("opened_at") + ((JSONObject)myMap.get("user2")).getString("opened_at") );
}
catch(Exception any){}