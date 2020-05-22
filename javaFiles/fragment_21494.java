//Somewhere you have declared your HashMap
HashMap<String,List<String>> myMap = new HashMap<String,List<String>>();

//then we continue with your excerpt  
try { 
JSONObject jsonMain = new JSONObject(jsonString);
JSONArray dataArray = jsonMain.getJSONArray("data");


for(int i = 0; i < dataArray.length(); i++) {
    JSONObject tagObject = dataArray.getJSONObject(i);
    String mandatory_tag = tagObject.getString("mandatory_tag");
    String id = tagObject.getString("id");

    if(myMap.containsKey(mandatory_tag)) {
         List<String> arrayID = myMap.get(mandatory_tag);
         arrayID.add(id);
    } else {
         List<String> newArrayID = new ArrayList<String>();
         newArrayID.add(id);
         myMap.put(mandatory_tag, newArrayID);
    }