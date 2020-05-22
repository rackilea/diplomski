Object part = json.get(0);
File saveTo = new File(dataPath("test.txt"));
if (part instanceof JSONObject){
  ((JSONObject)part).save(saveTo, "");
}
else if (part instanceof JSONArray){
  ((JSONArray)part).save(saveTo, "");
}