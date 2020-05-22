JsonParserFactory factory=JsonParserFactory.getInstance();
JSONParser parser=factory.newJsonParser();
Map jsonData=parser.parseJson(result);

List al=rootJson.get("root");
String id=((Map)al.get(0)).get("id");