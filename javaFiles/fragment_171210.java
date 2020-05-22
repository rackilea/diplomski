protected void parseJsonString(ArrayList<DEPT_HOLD> deptList,String json){
    try {
        JSONObject top = new JSONObject(json);
        JSONObject topAdds = (JSONObject) top.get("topAdds");
        JSONArray array = (JSONArray) topAdds.get("player");

        for(int i = 0; i < array.length(); i++) {
            JSONObject j = array.getJSONObject(i);
            DEPT_HOLD d = new DEPT_HOLD();
            d.one = j.optString("percent","");
            d.two = j.optString("id","");
            deptList.add(d);
        }
    } catch (JSONException e) {
        e.printStackTrace();
    }
}