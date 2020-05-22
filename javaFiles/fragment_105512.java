final Gson gson = new Gson();
final TypeToken<Map<String, Integer>> typeToken = new TypeToken<Map<String, Integer>>() {
};
final TypeAdapter<Map<String, Integer>> typeAdapter = gson.getAdapter(typeToken);
try ( final JsonReader jsonReader = getPackageResourceJsonReader(Q43528208.class, "non-standard.json") ) {
    final List<Map<String, Integer>> maps = parseToListLenient(jsonReader, typeAdapter::read);
    System.out.println(maps);
}