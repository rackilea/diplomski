Map<String, String> values = new HashMap<>();
String keyName = null;

JsonParser jsonParser = Json.createParser(new StringReader(json));

while (jsonParser.hasNext())
{
  JsonParser.Event event = jsonParser.next();

  if (JsonParser.Event.KEY_NAME.equals(event))
  {
    keyName = jsonParser.getString();
  }
  else if (JsonParser.Event.VALUE_STRING.equals(event))
  {
    values.put(keyName, jsonParser.getString());
  }
}