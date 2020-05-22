Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://hacker-news.firebaseio.com/").addConverterFactory(GsonConverterFactory.create())
                .build();

        GitHubService api = retrofit.create(GitHubService.class);

        api.listRepos().enqueue(new Callback<List<Long>>() {
            @Override
            public void onResponse(Call<List<Long>> call, Response<List<Long>> response) {
                if (response.isSuccessful()) {

                    // do operations here 
                    String number = "";
                    for (int i = 0; i < response.body().size(); i++)
                        number += response.body().get(i) + ", ";

                    ((TextView) findViewById(R.id.number)).setText(number);
                } else
                    Toast.makeText(MainActivity.this, response.errorBody().toString(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<List<Long>> call, Throwable t) {
            Toast.makeText(MainActivity.this, t.getMessage().toString(), Toast.LENGTH_LONG).show();
            }
        });