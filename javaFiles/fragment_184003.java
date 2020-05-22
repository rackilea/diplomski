int count = 0;
while(count <response.length()){
    try{
        JSONObject jsonObject = response.getJSONObject(count);
        Notis notis = new Notis(jsonObject.getString("time_mula"),
                jsonObject.getString("time_tamat"),jsonObject.getString("dt_mula"),jsonObject.getString("dt_tamat"),
                jsonObject.getString("notis_sebab"),jsonObject.getString("notis_lokasi"));
        arrayList.add(notis);
    }catch (JSONException e){
        Log.d("message:",e.getMessage());
    }
}