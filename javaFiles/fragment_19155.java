try ( final Reader reader = getPackageResourceReader(Q43695739.class, "dynamic.json") ) {
    final JsonElement jsonElement = gson.fromJson(reader, JsonElement.class)
            .getAsJsonObject()
            .getAsJsonObject("x")
            .getAsJsonObject("b")
            .getAsJsonArray("2");
    System.out.println(jsonElement);
}