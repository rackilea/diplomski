JsonStreamParser parser = new JsonStreamParser(new FileReader("sample.json"));

while (parser.hasNext()) {
    JsonElement object = parser.next();
    System.out.println(object.getAsJsonObject().get("reviewText"));
}