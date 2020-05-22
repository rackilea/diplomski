JSONObject issueInfo = new JSONObject(filePath));
JSONObject pages = issueInfo.getJSONObject("pages");
Iterator iterator = pages.keys();

while (iterator.hasNext()) {
    String key = (String) iterator.next();
    JSONObject page = pages.getJSONObject(key);
    JSONArray files = page.getJSONArray("files");  //Correction here
    String _thumbUri = files.getString(1);
    String _graphicUri = files.getString(2);
    String _textUri = files.getString(3);
}