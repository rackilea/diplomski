jsonReader.beginObject();

jsonReader.nextName();

while (jsonReader.hasNext() && jsonReader.peek() != JsonToken.END_DOCUMENT) {
    Set set = gson.fromJson(jsonReader, Set.class);
    sets.add(set);
    jsonToken = jsonReader.peek();
    if (jsonToken == JsonToken.NAME) {
        jsonReader.nextName();
    } else if (jsonToken != JsonToken.END_DOCUMENT) {
        jsonReader.endObject();
        jsonReader.skipValue();
        jsonToken = jsonReader.peek();
        if (jsonToken != JsonToken.END_DOCUMENT) {
            jsonReader.nextName();
        }
    }
}