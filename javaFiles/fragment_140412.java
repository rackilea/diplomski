public String listmap_to_json_string(List<Map<String, String>> list)
{       
    JSONArray json_arr=new JSONArray();
    for (Map<String, String> map : list) {
        JSONObject json_obj=new JSONObject();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            try {
                json_obj.put(key,value);
            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }                           
        }
        json_arr.put(json_obj);
    }
    return json_arr.toString();
}