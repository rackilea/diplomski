public static void parseJSON(String jsonString) {
  Gson gsonParser = new Gson();
  Map<String, ProveQuerySetting> gsonResponse; // You don't need to do new here
  Type collectionType = new TypeToken<Map<String, ProveQuerySetting>>() {}.getType();
  gsonResponse = gsonParser.fromJson(jsonString, collectionType);

  String str = gsonParser.toJson(gsonResponse);
  System.out.println(" final json " + str);
}