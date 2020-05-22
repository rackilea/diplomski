private void loadJSON(){
    final String url = "https://mydomainiscorrect.justreplacedithere/api/v1/";
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    final RequestInterfaceFeed request = retrofit.create(RequestInterfaceFeed.class);
    Call<List<FeedElement>> call = request.getJSON(apiKey);
    call.enqueue(new Callback<List<FeedElement>>() {
        @Override
        public void onResponse(Call<List<FeedElement>> call, retrofit2.Response<List<FeedElement>> response) {
            List<FeedElement> data = response.body();
            adapter = new DataAdapterFeed(data);
            recyclerView.setAdapter(adapter);
        }

        @Override
        public void onFailure(Call<List<FeedElement>> call, Throwable t) {
            Log.d("Error", t.getMessage());
        }
    });
}