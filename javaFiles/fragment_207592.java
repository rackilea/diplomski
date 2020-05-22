private static List<String> extractIds(JSONArray jsonArray) {
    List<String> ids = new ArrayList<>();
    Pattern pattern = Pattern.compile("id=\"([^\"]*)\"");
    for (int i = 0; i < jsonArray.length(); i++) {
        JSONObject o = jsonArray.getJSONObject(i);
        Iterator<String> keys = o.keys();
        while (keys.hasNext()) {
            String html = o.getString((String) keys.next());
            Matcher m = pattern.matcher(html);
            while (m.find()) {
                ids.add(m.group(1));
            }
        }
    }
    return ids;
}