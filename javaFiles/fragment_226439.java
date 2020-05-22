ArrayList<String> jsonStringToArray(String jsonString) throws JSONException {

    ArrayList<String> stringArray = new ArrayList<String>();

    JSONArray jsonArray = new JSONArray(jsonString);

    for (int i = 0; i < jsonArray.length(); i++) {
        stringArray.add(jsonArray.getString(i));
    }

    return stringArray;
}