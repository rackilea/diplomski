public static void main(String[] args) throws Exception {
    String url = "http://openexchangerates.org/api/latest.json?app_id=db98850be67e4d3d9a3ac0cf26ea2e40";
    String json = new Scanner(new URL(url).openStream(), "UTF-8").useDelimiter("\\A").next();
    JsonParser jsonParser = new JsonParser();
    System.out.println(jsonParser.parse(json));
}