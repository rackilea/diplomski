public boolean isJSONValid(final String str, final int id) {
    boolean valid = true;
    try {
        final JSONObject obj = new JSONObject(str);
        final JSONArray geodata = obj.getJSONArray("lv");
        final int n = geodata.length();

        for (int i = 0; i < n; ++i) {
            final JSONObject person = geodata.getJSONObject(i);
            JSONObject  menu = person.getJSONObject("v");
            if(menu.getInt("userId") != id) {
                valid = false;
                break;
            }
        }
    } catch (JSONException ex) {
        valid = false;
    }
    return valid;
}