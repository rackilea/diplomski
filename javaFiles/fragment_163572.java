JSONArray jsonarray = new JSONArray(datastr);
for(int i=0; i<jsonarray.length(); i++){
    JSONObject data= jsonarray.getJSONObject(i);

    System.out.println(data);
}