private void jsonObject() {
    String result =  "{\"data\": [{\"ID\": 47,\"kecamatan\": \"Benteng\",\"desa\": \"Benteng Selatan\"},{\"ID\": 48,\"kecamatan\": \"Benteng\",\"desa\": \"Benteng Selatan\"},{\"ID\": 49,\"kecamatan\": \"Benteng\",\"desa\": \"Benteng Utara\" },{\"ID\": 50,\"kecamatan\": \"Bontomantene\",\"desa\": \"Garaupa\"}]}";
    try {
        JSONObject jsonObject = new JSONObject(result);
        HashMap<String,Integer> hashMap = new HashMap<>();
        for (int i=0;i<jsonObject.getJSONArray("data").length();i++){
            JSONObject innerJsonObject = jsonObject.getJSONArray("data").getJSONObject(i);
            String key = innerJsonObject.getString("kecamatan")+" ["+innerJsonObject.getString("desa")+"]";
            if(hashMap.containsKey(key)){
                int count = hashMap.get(key)+1;
                hashMap.put(key,count);
            }else {
                hashMap.put(key,1);
            }
        }
        Log.e("Hashmap---",hashMap.toString());
    } catch (JSONException e) {
        e.printStackTrace();
    }
}