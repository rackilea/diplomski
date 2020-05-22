public static JSONObject saveValues(ArrayList<List<Integer>> pos1, ArrayList<List<Integer>> pos2)
        throws JSONException {
    JSONObject obj = new JSONObject();
    JSONObject collocation = new JSONObject();
    JSONArray first = new JSONArray();
    JSONArray second = new JSONArray();

    for (int i = 0; i < pos1.size(); i++) {
        JSONArray arr = new JSONArray();
        for (int j = 0; j < pos1.get(i).size(); j++) {
            arr.put(pos1.get(i).get(j));
        }
        first.put(arr);
    }
    for (int i = 0; i < pos2.size(); i++) {
        JSONArray arr = new JSONArray();
        for (int j = 0; j < pos2.get(i).size(); j++) {
            arr.put(pos2.get(i).get(j));
        }
        second.put(arr);
    }

    collocation.put("first", first);
    collocation.put("second", second);
    obj.put("collocation", collocation);

    return obj;
}