JSONArray posterJsonArray = imagesJsonObject.getJSONArray("poster");
List<String> urls = new ArrayList<String>();
for (int i = 0; i < posterJsonArray.length(); i++) {
    String url = posterJsonArray.getString(i);
    urls.add(url);
}