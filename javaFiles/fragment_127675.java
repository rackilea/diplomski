JSONArray jsonArray = jsonObject.getJSONArray("destinations");
 for (int i = 0; i < jsonArray.length(); i++) {
        JSONObject jsonObject = jsonArray.getJSONObject(i);
        String name= jsonObject.getString("name");
        items.add(name);
        Log.d(name,"Output");
 }