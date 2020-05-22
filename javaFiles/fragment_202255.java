Call<NewsAPI> call = client.getData("techcrunch", "APIkeygoeshere");

call.enqueue(new Callback<NewsAPI>() {
    @Override
    public void onResponse(Call<List<NewsAPI>> call, Response<List<NewsAPI>> response) {
        final NewsAPI responseBody = response.body();
        if (responseBody != null) {
            tvTest.setText(responseBody.toString());

            String news = news.source + " (" + news.status + ")";
            Log.i("responseBody", news);
            tvTest.setText(news);

        } else {
            tvTest.setText("It's null, " + response.errorBody().toString() + ", " + call.request().url());
        }
    }

    @Override
    public void onFailure(Call<List<NewsAPI>> call, Throwable t) {
        tvTest.setText("An error ocurred!");
        Log.e("news Error", t.getMessage());
    }
});