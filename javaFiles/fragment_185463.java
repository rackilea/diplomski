Object part = json.get(0);
File saveTo = new File(dataPath("test.txt"));
if (part.getClass() == JSONObject.class){
  ((JSONObject)part).save(saveTo, "");
}
else if (part.getClass() == JSONArray.class){
  ((JSONArray)part).save(saveTo, "");
}