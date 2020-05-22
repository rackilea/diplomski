@Override
protected void onPostExecute(String s) {

    try {
        JSONObject jsonObject = new JSONObject(result);

        JSONArray jsonArray = jsonObject.getJSONArray("articles");

        for(int i = 0; i<jsonArray.length(); i++){

            News news = new News();

            news.setHeading(String.valueOf(article_heading.add(jsonArray.getJSONObject(i).optString("title"))));

           // article_heading.add(jsonArray.getJSONObject(i).optString("title"));


            Log.d("news_JSON", article_heading.toString());

            Log.d("news", news.getHeading().toString());
            news_list.add(news);

        }

    } catch (JSONException e) {
        e.printStackTrace();
    }
    mViewAdapter= new MyAdapter(news_list);
    mRecyclerView.setAdapter(mViewAdapter);
    mViewAdapter.notifyDataSetChanged().
    super.onPostExecute(s);
}