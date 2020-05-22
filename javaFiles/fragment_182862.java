@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    FacebookSdk.sdkInitialize(this);
    setContentView(R.layout.activity_main);


    callbackManager = CallbackManager.Factory.create();

    login = (LoginButton) findViewById(R.id.btn_login);
    login.setReadPermissions("email", "public_profile");
    login.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
        @Override
        public void onSuccess(LoginResult loginResult) {
            GraphRequest request = GraphRequest.newMeRequest(loginResult.getAccessToken(), new GraphRequest.GraphJSONObjectCallback() {
                @Override
                public void onCompleted(JSONObject object, GraphResponse response) {

                    String id = object.getString("id");
                    // some database stuff here
                    // ...
                }
            });
            request.executeAsync();
        }

        @Override
        public void onCancel() {

        }

        @Override
        public void onError(FacebookException error) {
            Log.d("ERROR", error.toString());
            Toast.makeText(MainActivity.this, "Couldn't login, pleasy try again!", Toast.LENGTH_SHORT).show();
        }
    });

}