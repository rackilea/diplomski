private void parseData(JSONArray array){
    Log.d(TAG, "Parsing array");

    for(int i = 0; i<array.length(); i++) {
        PostItems postItem = new PostItems();
        JSONObject jsonObject = null;
        try {
            jsonObject = array.getJSONObject(i);

   postItem.setPost_title(jsonObject.getString(ConfigPost.TAG_POST_TITLE));

   postItem.setPost_body(jsonObject.getString(ConfigPost.TAG_POST_BODY));

    //Parsing featured_picture object
   JSONObject postImage = jsonObject.getJSONObject("featured_picture");

   postItem.setPost_image(postImage.getString("source"));


        } catch (JSONException w) {
            w.printStackTrace();
            //Toast.makeText(this, "Error in parsing Json", Toast.LENGTH_LONG).show();
        }
        mPostItemsList.add(postItem);
    }

}