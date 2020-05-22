private static List<News> extractFeatureFromJson(String newsJSON) {
    if (TextUtils.isEmpty(newsJSON)) {
        return null;
    }
    List<News> news = new ArrayList<>();
    try {
        JSONObject baseJsonResponse = new JSONObject(newsJSON);
        String response = baseJsonResponse.getString("response");
        JSONObject object = new JSONObject(response);;
        JSONArray newsArray=object.getJSONArray("results");
        for (int i = 0; i < newsArray.length(); i++) {
            JSONObject currentNews = newsArray.getJSONObject(i);
            String title = currentNews.getString("webTitle");
            String section = currentNews.getString("sectionName");
            JSONArray tag = currentNews.getJSONArray("tags");
            String firstName;
            if(tag.length() != 0){
                firstName = tag.getJSONObject(0).getString("firstName");
            }
            String url = currentNews.getString("webUrl");

            News nNews = new News(title, section, author, url);

            news.add(nNews);
        }

    } catch (JSONException e) {
        Log.e("QueryUtils", "Problem parsing the news JSON results", e);
    }
    return news;
}