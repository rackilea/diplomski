JSONObject jobj  = new JSONObject(str);

if(jobj.has("datas")){    
    JSONArray jsonArray = jobj.getJSONArray("datas");
    List<City> list = new ArrayList<>();

    for (int i = 0; i < jsonArray.length(); i++) {
        JSONObject jdataObj = jsonArray.getJSONObject(i);    
        City city = new City();
        city.setId(jdataObj.getString("id"));
        city.setName(jdataObj.getString("name"));
        city.setSortKey(jdataObj.getString("sortKey"));
        list.add(city);
    }
} else {
    Log.e("Json","Json has no datas key.")
}