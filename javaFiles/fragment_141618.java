public ArrayList<NewsItem> getNews(String url) {
    ArrayList<NewsItem> data = new ArrayList<NewsItem>();

    java.lang.reflect.Type arrayListType = new TypeToken<ArrayList<NewsItem>>(){}.getType();
    gson = new Gson();

    httpClient = WebServiceUtils.getHttpClient();
    try {
        HttpResponse response = httpClient.execute(new HttpGet(url));
        HttpEntity entity = response.getEntity();
        Reader reader = new InputStreamReader(entity.getContent());
        data = gson.fromJson(reader, arrayListType);
    } catch (Exception e) {
        Log.i("json array","While getting server response server generate error. ");
    }
    return data;
}