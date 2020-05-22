JSONParser parser = new JSONParser();
Object obj = parser.parse(output);
JSONArray array = (JSONArray)obj;
JSONArray politics = ((JSONObject)array.get(0)).get("politics"));
JSONObject obj = null;
for(int i = 0; i < politics.size(); i++){
    if(((JSONObject)politics.get(i)).getString("type").equals("admin4")){
        obj = ((JSONObject)politics.get(i));
    }
}
if(obj != null){
    // Do something with the object.
}