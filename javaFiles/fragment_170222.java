JsonParserFactory factory=JsonParserFactory.getInstance();
JSONParser parser=factory.newJsonParser();
Map jsonData=parser.parseJson(result);

List list=(List) jsonData.get("root");
String id=(String) ((Map)list.get(0)).get("adid");