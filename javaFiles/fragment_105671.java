private Callback<TwitterSession> authorizeCallback = new Callback<TwitterSession>() {

    @Override
    public void success(com.twitter.sdk.android.core.Result<TwitterSession> result) {

        TwitterSession session = Twitter.getSessionManager().getActiveSession();

        if (isNetworkAvailable(this)) {
            if (session != null) {
                TwitterApiServices apiclients = new TwitterApiServices(session);
                Call<Response> call = apiclients.getCustomService().show(result.data.getUserId(), result.data.getUserName(), true, false, 100);
                call.enqueue(new retrofit2.Callback<Response>() {
                    @Override
                    public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                        if (response.body().getUsers().size() > 0) {

                            ArrayList<TwitterFollowersList> twitterFollowersList = new ArrayList<>();

                            for (int i = 0; i < response.body().getUsers().size(); i++) {

                                TwitterFollowersList twitterFollowers = new TwitterFollowersList();

                                twitterFollowers.setId(response.body().getUsers().get(i).getId());
                                twitterFollowers.setName(response.body().getUsers().get(i).getName());
                                twitterFollowers.setProfile_image_url(response.body().getUsers().get(i).getProfile_image_url());

                                Log.d("TwitterFollowers", "ID: " + response.body().getUsers().get(i).getId() + "  Name: " + response.body().getUsers().get(i).getName() + "  ProfileImageURL: " + response.body().getUsers().get(i).getProfile_image_url());

                                twitterFollowersList.add(twitterFollowers);
                            }
                            //Upload twitter folowers to server.
                            uploadUserTwitterContacts(twitterFollowersList);
                        }
                    }

                    @Override
                    public void onFailure(Call<Response> call, Throwable t) {
                        showToast(this, "Unable to get response. Try Again!!");
                    }
                });
            } else {
                showToast(this, getResources().getString(R.string.server_error));

            }
        } else {
            showToast(this, getResources().getString(R.string.no_internet));
        }
    }

    @Override
    public void failure(TwitterException e) {
        showToast(this, getResources().getString(R.string.server_error));

    }
};