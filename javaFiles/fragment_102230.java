int numObject = jsonArray.length();
JSONArray repackArray = new JSONArray();
for(int i = 0; i < numObject; i++){
    JSONObject nested = jsonArray.getJsonObject(i);

    //get values you need
    String email = nested.getString("email");
    String language = nested.getString("language");
    String name = nested.getString("name");

    //add values to new object
    JSONObject repack = new JSONObject();
    repack.put("email", email);
    repack.put("language", language);
    repack.name("name", name);

    //add to new array 
    repackArray.put(repack);
 }