private LoginButton loginButton;
CallbackManager callbackManager;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login);

    loginButton = (LoginButton) findViewById(R.id.login_button);

    loginButton.setReadPermissions(Arrays.asList("public_profile, email, user_birthday"));

    callbackManager = CallbackManager.Factory.create();

    // Callback registration
    loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
        @Override
        public void onSuccess(LoginResult loginResult) {
            // App code
            GraphRequest request = GraphRequest.newMeRequest(
                    loginResult.getAccessToken(),
                    new GraphRequest.GraphJSONObjectCallback() {
                        @Override
                        public void onCompleted(
                                JSONObject object,
                                GraphResponse response) {
                            // Application code
                            Log.v("LoginActivity", response.toString());
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
            Log.v("LoginActivity", exception.getCause().toString());
        }
    });


}