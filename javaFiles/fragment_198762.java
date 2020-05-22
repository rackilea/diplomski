public static void main(String[] args) {
  String json1 = "{\"name\":\"ABC\", \"city\":\"XYZ\", \"state\":\"CA\"}";
  String json2 = "{\"city\":\"XYZ\", \"street\":\"123 anyplace\", \"name\":\"ABC\"}";

  Gson g = new Gson();
  Type mapType = new TypeToken<Map<String, Object>>(){}.getType();
  Map<String, Object> firstMap = g.fromJson(json1, mapType);
  Map<String, Object> secondMap = g.fromJson(json2, mapType);
  System.out.println(Maps.difference(firstMap, secondMap));
}