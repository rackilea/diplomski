final URL resource = YourClass.class.getResource("loadData.json");
final Path path = Paths.get(resource.toURI());
final byte[] bytes = Files.readAllBytes(path);
final String fileContent = new String(bytes);

final Object object = jparser.parse(fileContent);
final JSONObject jObject = (JSONObject) object;