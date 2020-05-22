public static void main(String[] args) throws JSONException {
    JSONArray array = new JSONArray("[" +
            "    {" +
            "        originalName      : \"Case #\"," +
            "        modifiedLabel     : \"Case #\"," +
            "        labelId           : \"case_number_lbl\"," +
            "        isEditable        : \"true\"," +
            "        imageClass        : \"\"" +
            "    }" +
            "]");

    System.out.println(array.toString(2));

    for (int i = 0; i < array.length(); i++) {
        JSONObject object = array.getJSONObject(i);
        JSONArray keys = object.names();
        for (int j = 0; j < keys.length(); j++) {
            String key = keys.getString(j);
            if (object.getString(key).equals("Case #")) {
                object.put(key, "Ticket #");
            }
        }
    }

    System.out.println();
    System.out.println(array.toString(2));
}