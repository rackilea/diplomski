try (final InputStream is = YourClass.class.getResourceAsStream("loadData.json")) {
    final String fileContent = readString(is);
    final Object object = jparser.parse(fileContent);
    final JSONObject jObject = (JSONObject) object;
    ...
}