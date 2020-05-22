protected void connectToFacebook() {
    ArrayList<String> list = new ArrayList<String>();
    list.add("email");
    // LoginManager.getInstance().logInWithReadPermissions(this, list);
    LoginManager.getInstance().logInWithReadPermissions(this, Arrays.asList("email", "user_photos", "public_profile"));

    LoginManager.getInstance().registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
        @Override
        public void onSuccess(LoginResult loginResult) {
            // App code
            GraphRequest request = GraphRequest.newMeRequest(loginResult.getAccessToken(), new GraphRequest.GraphJSONObjectCallback() {
                @Override
                public void onCompleted(JSONObject json, GraphResponse response) {
                    // Application code
                    if (response.getError() != null) {
                        System.out.println("ERROR");
                    } else {
                        System.out.println("Success");
                        String jsonresult = String.valueOf(json);
                        System.out.println("JSON Result" + jsonresult);

                        String fbUserId = json.optString("id");
                        String fbUserFirstName = json.optString("name");
                        String fbUserEmail = json.optString("email");
                        String fbUserProfilePics = "http://graph.facebook.com/" + fbUserId + "/picture?type=large";
                        callApiForCheckSocialLogin(fbUserId, fbUserFirstName, fbUserEmail, fbUserProfilePics, "fb");
                    }
                    Log.v("FaceBook Response :", response.toString());
                }
            });
            Bundle parameters = new Bundle();
            parameters.putString("fields", "id,name,email,gender, birthday");
            request.setParameters(parameters);
            request.executeAsync();


        }

        @Override
        public void onCancel() {
            // App code
            Log.v("LoginActivity", "cancel");
        }

        @Override
        public void onError(FacebookException exception) {
            // App code
            // Log.v("LoginActivity", "" + exception);
            Utilities.showToast(mActivity, "" + exception);
        }
    });
}