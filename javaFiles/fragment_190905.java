fbLoginBtn.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
    @Override
    public void onSuccess(LoginResult loginResult) {
        GraphRequest.newMeRequest(
            loginResult.getAccessToken(), new GraphRequest.GraphJSONObjectCallback() {
                @Override
                public void onCompleted(JSONObject me, GraphResponse response) {
                    if (response.getError() != null) {
                        // handle error
                    } else {
                        String email = me.optString("email");
                        String id = me.optString("id");
                        // send email and id to your web server
                    }
                }
            }).executeAsync();
    }

    @Override
    public void onCancel() {
        // App code
    }

    @Override
    public void onError(FacebookException exception) {
        // App code
    }
});