private static List<News> extractResultFromJson(String newsJSON) {
    if (TextUtils.isEmpty(newsJSON)) {
        return null;
    }

    List<News> newss = new ArrayList<>();
    try {

        JSONObject baseJsonResponse = new JSONObject(newsJSON);
        JSONObject mainResponse = baseJsonResponse.getJSONObject("response");

        JSONArray newsArray = mainResponse.getJSONArray("results");

        for (int i = 0; i < newsArray.length(); i++) {

            JSONObject currentNews = newsArray.getJSONObject(i);

            String title = currentNews.getString("webTitle");

            long date = currentNews.getLong("webPublicationDate");

            String url = currentNews.getString("webUrl");

            News news = new News(title, date, url);

            newss.add(news);
        }

    } catch (JSONException e) {
        Log.e("QueryUtils", "Problem parsing the news JSON results", e);
    }

    return newss;
}