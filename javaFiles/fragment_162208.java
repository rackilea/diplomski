JsonFactory f = new JsonFactory();
JsonParser jp = f.createJsonParser(new File("positions.json"));
List<Position> positions = new LinkedList<Position>();
jp.nextToken(); // will return JsonToken.START_OBJECT (verify?)
while (jp.nextToken() != JsonToken.END_OBJECT) {
  String fieldname = jp.getCurrentName();
  jp.nextToken(); // move to value, or START_OBJECT/START_ARRAY
  if ("positions".equals(fieldname)) { // contains an object
    Position pos = new Position();
    while (jp.nextToken() != JsonToken.END_OBJECT) {
      String namefield = jp.getCurrentName();
      jp.nextToken(); // move to value
      if ("value".equals(namefield)) {
        pos.setValue(jp.getText());
      } 
  }
}
jp.close();