final Gson gson = new Gson();
final List<String> ids = gson.fromJson(JSON, JsonElement.class)
        .getAsJsonObject()
        .get("divisions") // get the divisions property
        .getAsJsonObject()
        .entrySet() // and traverse its key/value pairs
        .stream()
        .map(Entry::getValue) // discarding the keys
        .map(JsonElement::getAsJsonObject)
        .map(jo -> jo.get("id")) // take the id property from the every `division` object
        .map(JsonElement::getAsJsonPrimitive)
        .map(JsonPrimitive::getAsString)
        .collect(toList());
System.out.println(ids);