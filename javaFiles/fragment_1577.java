private void jSONLoadData(String response) throws JSONException{

    //talk about this in getting the video url
    JSONObject obj = new JSONObject(response);
    JSONArray jArray = obj.getJSONArray("data");

    for(int i=0; i<jArray.length() ; i++){
        JSONObject jsonObj = jArray.getJSONObject(i);
        boolean isURLNull = jsonObj.getJSONObject("attributes").isNull("video_url");
        String url="";
        if(!isURLNull){
            url = jsonObj.getJSONObject("attributes").getString("video_url");
        }
        if(isURLNull || url.equals("")){
            Toast.makeText(getApplicationContext(), "Empty", Toast.LENGTH_SHORT)
                    .show();
        }
    }
}