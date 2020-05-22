//manager to handle callbacks from Facebook
private CallbackManager callbackManager;

@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    callbackManager = CallbackManager.Factory.create();

    LoginManager.getInstance().registerCallback(callbackManager, getFacebookLoginCallback());
}

public FacebookCallback<LoginResult> getFacebookLoginCallback() {
    return new FacebookCallback<LoginResult>() {
        @Override
        public void onSuccess(final LoginResult loginResult) {
            ICLog.e(TAG, "Facebook access token: " + loginResult.getAccessToken().getToken());
            if (loginResult.getRecentlyGrantedPermissions().contains("email")) {
                GraphRequest request = GraphRequest.newMeRequest(
                        loginResult.getAccessToken(),
                        new GraphRequest.GraphJSONObjectCallback() {
                            @Override
                            public void onCompleted(JSONObject object, GraphResponse response) {
                                // Handle logged user here
                            }
                        });
                Bundle parameters = new Bundle();
                parameters.putString("fields", "id,name,email,gender,birthday,first_name,last_name");
                request.setParameters(parameters);
                request.executeAsync();
            } else {
                //show popup and request e-mail permission if needed
                new AlertDialog.Builder(this)
                        .setMessage("I need email")
                        .setNegativeButton("Cancel", null)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface arg0, int arg1) {
                                LoginManager.getInstance().logInWithReadPermissions(this, Arrays.asList("email"));
                            }
                        }).create().show();
            }
        }

        @Override
        public void onCancel() {
              Log.e("Facebook login", "onCancel");
        }

        @Override
        public void onError(FacebookException exception) {//log out user if any error appears
            if (exception instanceof FacebookAuthorizationException) {
                if (AccessToken.getCurrentAccessToken() != null) {
                    LoginManager.getInstance().logOut();
                }
            }
        }
    };
}