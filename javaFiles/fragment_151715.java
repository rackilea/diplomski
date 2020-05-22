ArrayList<Template> tm = new ArrayList<>();
JSONObject reader = new JSONObject(format);
JSONObject config = reader.getJSONObject("format");
Iterator<String> types = config.keys();
while (types.hasNext()) {
String name = types.next();
tm.add(new Template(name, config.getJSONArray(name)));
}