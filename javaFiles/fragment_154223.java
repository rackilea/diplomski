JsonArray jsonObject = new JsonParser()
        .parse(json)
        .getAsJsonArray();

List<String> names = new ArrayList<>();
for (JsonElement jsonElement : jsonObject) {
    names.add(jsonElement.getAsJsonObject().get("name").getAsString());
}

//now you can use as you wish, by index
System.out.println(names.get(1));//returns "name2"