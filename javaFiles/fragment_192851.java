InputStream is = new URL(url).openStream();
BufferedReader r = new BufferedReader(new InputStreamReader(
                is, Charset.forName("UTF-8")));
JsonReader reader = new JsonReader(r);
JsonParser parser = new JsonParser();

reader.beginObject(); // the initial '{'
String name = reader.nextName();
assert "Documents".equals(name);
reader.beginArray(); // the opening '[' of the Documents array
while(reader.hasNext()) {
  JsonObject doc = parser.parse(reader).getAsJsonObject();
  String action = doc.get("Action").getAsString();
  JsonArray filenames = doc.getAsJsonArray("Filenames");
  // do something with the document here
  // ...
}

reader.endArray(); // ending ']' of Documents
reader.endObject(); // final '}'
reader.close();