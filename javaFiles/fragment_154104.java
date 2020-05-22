private static String getLessWeather(String weatherJson) throws IOException {
  Map<String, Object> lessWeatherMap = new LinkedHashMap<String, Object>();
  Map<String,Object> weatherMap = new ObjectMapper().readValue(weatherJson, LinkedHashMap.class);
  String main = (String) ((LinkedHashMap)((ArrayList)weatherMap.get("weather")).get(0)).get("main");
  lessWeatherMap.put("main", main);
  Double temp = (Double)((LinkedHashMap)weatherMap.get("main")).get("temp");
  lessWeatherMap.put("temp", temp);
  return new ObjectMapper().writeValueAsString(lessWeatherMap);
}