List<String> titles = new ArrayList<String>();
List<String> images = new ArrayList<String>();
for (int i = 0; i < boombaby.length(); i++) {
    JSONObject e = boombaby.getJSONObject(i);
    titles.add(e.getString("title"));
    images.add(e.getString("image"));
}