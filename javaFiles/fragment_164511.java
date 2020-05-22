api.getObject(URL, paramsMap, new GetObjectCallback<NewsItem>() {
    @Override
    public void onSuccess(NewsItem item) {
        // do something
    }

    @Override
    public void onFailure() {
        // do something
    }
});