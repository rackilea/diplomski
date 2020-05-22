try {
    JSONObject obj = new JSONObject(json);
    categoryGetSet temp;

    JSONObject resultObject = (JSONObject) obj.get("result");

    String txt_title = resultObject.getString("title");
    String txt_provider = resultObject.getString("provider");
    JSONArray ja_video = resultObject.getJSONArray("link");

    for (int i = 0; i < ja_video.length(); ++i) {
        temp = new categoryGetSet();
        JSONObject jo_data = ja_video.getJSONObject(i);
        String txt_link_name = jo_data.getString("link_name");
        String txt_video = jo_data.getString("video_link");

        temp.setTitle(txt_title);
        temp.setLinkName(txt_link_name);
        temp.setImage(txt_provider);
        temp.setVideo(txt_video);

        Log.e("jsonResponse: ", "txt_title" + txt_title);
        Log.e("jsonResponse: ", "txt_link_name" + txt_link_name);
        Log.e("jsonResponse: ", "txt_provider" + txt_provider);
        Log.e("jsonResponse: ", "txt_video" + txt_video);
    }
} catch (JSONException e) {
    e.printStackTrace();
    Log.e("catch", e.getLocalizedMessage());
}