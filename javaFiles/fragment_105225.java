public void parseJson(JSONObject json) {
try {
        JSONArray posts = json.getJSONArray("resume");
        feedList = new ArrayList<JsonItem>();
        for (int i = 0; i < posts.length(); i++) {
            JSONObject post = (JSONObject) posts.getJSONObject(i);

            JSONArray cast = post.getJSONArray("Education");
            Log.i("lenght", Integer.toString(cast.length()));
            if (cast != null && cast.length()>0) {
                for(int j =0 ;j<cast.length();j++){                       

                   JsonItem item = new JsonItem();

                   JSONObject casts = (JSONObject)cast.getJSONObject(j);
                   item.setTitle(casts.getString("Title"));
                   feedList.add(item);
                   Log.i("feedsize", feedList.get(j).toString());
                }
            }


        }
    } catch (JSONException e) {
         e.printStackTrace();
    }
}