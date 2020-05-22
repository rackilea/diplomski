// Read the request payload into a String
StringBuilder buffer = new StringBuilder();
BufferedReader reader = request.getReader();
String line;
while ((line = reader.readLine()) != null) {
    buffer.append(line);
}
String data = buffer.toString();

// If the String is not empty, parses the payload into a map
Map<String, Object> jsonMap = null;
if (!data.isEmpty()) {
    ObjectMapper mapper = new ObjectMapper();
    jsonMap = mapper.readValue(data, Map.class);
}