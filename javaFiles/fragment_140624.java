HashMap<String, String> map;
try {
    for(int i=0;i<json.length();i++){
        map = new HashMap<String, String>();
        e =json.getJSONObject(i);
        map.put("id", String.valueOf(i));
        map.put("Name", "Vorname: " + e.getString("meta_value"));
        map.put("orderid", "id: " + e.getString("post_id"));
        arrayList.add(map);
    }