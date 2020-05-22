public void loadGithubUserRepositoryJson() {
    api.listRepos("motivecodex").enqueue(new Callback<List<GithubRepository>>() {
    @Override
    public void onResponse(Call<List<GithubRepository>> call, Response<List<GithubRepository>> response) {
        try {
            Log.e(LOG_TAG, response.body().string());

            mGithubAdapter = new GithubRepositoriesAdapter(response.body());
            mGithubRecyclerView.setAdapter(mGithubAdapter);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onFailure(Call<List<GithubRepository>> call, Throwable t) {
        Log.e("MainActivity", "error loading from API");
    }
});
}