public void storeInPrefs(){
    JSONArray data = new JSONArray();
    for (int i = 0; i < list.size(); i++) {

        JSONObject industry = new JSONObject();
        ParseObject foundObject = list.get(i);
        try {
            industry.put("CategoryName", foundObject.get("category"));
            industry.put("lastUpdated", new Date());
            industry.put("Jobs", foundObject.getList("jobs"));
            data.put(industry);
        }
        catch (JSONException e) {
            e.printStackTrace();
        }
    }
    SharedPreferences preferences = this.getPreferences(MODE_PRIVATE);
    SharedPreferences.Editor editor = preferences.edit();
    editor.putString("Categories", data.toString());
    editor.commit();
}