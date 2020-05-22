private void jsonParsingVideoData(String projectVideos, String projectId) throws JSONException{
    JSONArray jsonArray = new JSONArray(projectVideos);

    ArrayList<String> video_urls = new ArrayList<String>();
    for(int i = 0; i < jsonArray.length(); i++){
        JSONObject jObject = jsonArray.getJSONObject(i);

        video_urls.add(jObject.getString("video_url"));
    }
}