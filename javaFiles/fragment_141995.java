//Getting the account service of the user logged in
    Call<User> call = Twitter.getApiClient(session).getAccountService()
            .verifyCredentials(true, false);
    call.enqueue(new Callback<User>() {
            @Override
            public void failure(TwitterException e) {
                //If any error occurs handle it here
            }
            @Override
            public void success(Result<User> userResult) {
                //If it succeeds creating a User object from userResult.data
                User user = userResult.data;
                setProfilePic(user.profileImageUrl.replace("_normal", ""));
                twitterLoginButton.setVisibility(View.GONE);
            }
        });