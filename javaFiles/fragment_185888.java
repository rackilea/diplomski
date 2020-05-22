protected Void doInBackground(Void... params) {
    // Create an array
    arraylist = new ArrayList<HashMap<String, String>>();
    // Retrieve JSON Array from the given URL address
    jsonarray = new JSONArray(JSONfunctions.getJSONfromURL("http://www.mywebsite.club/api/coffees"));

    try {
         if(jsonarray != null)
         {

          for (int i = 0; i < jsonarray.length(); i++) {
            HashMap<String, String> map = new HashMap<String, String>();
            jsonobject = jsonarray.getJSONObject(i);
            // Retrive JSON Objects
            map.put("title", jsonobject.getString("title"));
            map.put("brand", jsonobject.getString("brand"));
            map.put("price", jsonobject.getInt("price"));
            map.put("brandlogo", jsonobject.getString("brandlogo"));
            // Set the JSON Objects into the array
            arraylist.add(map);
          }
       }
    } catch (JSONException e) {
        Log.e("Error", e.getMessage());
        e.printStackTrace();
    }
    return null;
}