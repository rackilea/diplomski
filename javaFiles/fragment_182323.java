public static void main() throws ParseException {
  String JSON_STRING = "[{\"name\": \"adminparking1\", \"id\": 1},{\"name\": \"adminparking2\", \"id\": 2}]";
  JSONParser jsonParser = new JSONParser();
  Object res_obj = jsonParser.parse(JSON_STRING);
  JSONArray json = (JSONArray) res_obj; // no Error
  System.out.println(json.get(1));
}