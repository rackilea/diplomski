public static JSONArray sortJsonArray(JSONArray array) {
    List<JSONObject> jsons = new ArrayList<JSONObject>();
    for (int i = 0; i < array.length(); i++) {
        jsons.add(array.getJSONObject(i));
    }
    Collections.sort(jsons, new Comparator<JSONObject>() {
        @Override
        public int compare(JSONObject lhs, JSONObject rhs) {
            String lid = lhs.getString("comment_id");
            String rid = rhs.getString("comment_id");
            // Here you could parse string id to integer and then compare.
            return lid.compareTo(rid);
        }
    });
    return new JSONArray(jsons);
}