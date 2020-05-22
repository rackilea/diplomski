public List<NewsObj> constructJSON(String jsonIN){
ArrayList<NewsObj> newsList = new ArrayList<>();
try{
    //add more levels to extract json
    JSONObject jsonObject1 = new JSONObject(jsonIN);
    String responseData = jsonObject1.getString("responseData");
    Log.d("RECEIVEJSONOBJECTLEVEL1",responseData);

    JSONObject jsonObject2 = new JSONObject(responseData);
    String feed = jsonObject2.getString("feed");
    Log.d("RECEIVEJSONOBJECTLEVEL2",feed);

    JSONObject jsonObject3 = new JSONObject(feed);
    String entries = jsonObject3.getString("entries");
    Log.d("RECEIVEJSONOBJECTLEVEL3", entries);

    JSONArray jsonArray1 = new JSONArray(entries);
    for(int i=0; i<jsonArray1.length();i++){
        JSONObject mediaGroups = jsonArray1.getJSONObject(i);
        String mediaItems = mediaGroups.getString("mediaGroups");
        String title = mediaGroups.getString("title");
        String url = mediaGroups.getString("link");
        String description = mediaGroups.getString("contentSnippet");
        String publishedDate = mediaGroups.getString("publishedDate");
       //                main information for news article

        //for further thumbnail sizes?
        JSONArray jsonArray2 = new JSONArray(mediaItems);
        for(int j=0;j<jsonArray2.length();j++){
            JSONObject contents = jsonArray2.getJSONObject(j);
            String contentItems = contents.getString("contents");
            Log.d("RECEIVEJSONOBJECTARRAY2",contentItems);

            JSONArray jsonArray3 = new JSONArray(contentItems);
            for(int k=0;k<jsonArray3.length();k++){
                JSONObject items = jsonArray3.getJSONObject(k);
                //too specific
                String imgurl = items.getString("url");
                //Log.d("RECEIVEJSONOBJECTARRAY3",imgurl);

                String thumbnails = items.getString("thumbnails");

                JSONArray jsonArray4 = new JSONArray(thumbnails);
                for(int l=0;l<jsonArray4.length();l++){
                JSONObject thumbnails1 = jsonArray4.getJSONObject(l);

                String height = items.getString("height");
                String width = items.getString("width");
                String thumburl = items.getString("url");

                }
                NewsObj aObj = new NewsObj(title, imgurl,url, publishedDate);
                newsList.add(aObj);
            }
        }
    }

}catch (JSONException e){
    e.printStackTrace();
    Log.d("RECEIVEJSONERROR",e.toString());
}
return newsList;
}