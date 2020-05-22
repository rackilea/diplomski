private JSONObject readFromJsonUrl() throws IOException, JSONException {
    InputStream is = new URL(this.fullUrl).openStream();
    BufferedReader br = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
    String jsonText = readAll(br);
    //jsonObject = new JSONObject(jsonText);
    ObjectMapper objectMapper = new ObjectMapper();
    JSONObject jsonObject = objectMapper.readValue(jsonText, JSONObject.class);
    return jsonObject;
}