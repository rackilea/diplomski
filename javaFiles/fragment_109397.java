private static JsonElement parseRecursive(JsonReader reader)
            throws IOException {
        switch (reader.peek()) {
        case STRING:
            return new JsonPrimitive(reader.nextString());
        case NUMBER:
            String number = reader.nextString();
            return new JsonPrimitive(JsonPrimitive.stringToNumber(number));
        case BOOLEAN:
            return new JsonPrimitive(reader.nextBoolean());
        case NULL:
            reader.nextNull();
            return JsonNull.createJsonNull();
        case BEGIN_ARRAY:
            JsonArray array = new JsonArray();
            reader.beginArray();
            while (reader.hasNext()) {
                array.add(parseRecursive(reader));
            }
            reader.endArray();
            return array;
        case BEGIN_OBJECT:
            JsonObject object = new JsonObject();
            reader.beginObject();
            while (reader.hasNext()) {
                object.add(reader.nextName(), parseRecursive(reader));
            }
            reader.endObject();
            return object;
        case END_DOCUMENT:
        case NAME:
        case END_OBJECT:
        case END_ARRAY:
        default:
            throw new IllegalArgumentException();
        }
    }