@Override
    protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    FacebookSdk.sdkInitialize(getApplicationContext());
    mCallbackManager = CallbackManager.Factory.create();

    setContentView(R.layout.activity_login);

    loginButton = (LoginButton) findViewById(R.id.login_button);

    loginButton.setReadPermissions(Arrays.asList("public_profile, email, user_birthday, user_photos, user_friends"));
    loginButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            loginButton.registerCallback(mCallbackManager, new FacebookCallback<LoginResult>() {

                private ProfileTracker mProfileTracker;

                @Override
                public void onSuccess(final LoginResult loginResult) {
                    loginButton.setVisibility(View.INVISIBLE);
                    mProfileTracker = new ProfileTracker() {
                        @Override
                        protected void onCurrentProfileChanged(Profile profile1, Profile profile) {

                            final String userId = loginResult.getAccessToken().getUserId();

                            String profileImgUrl = "https://graph.facebook.com/" + userId + "/picture?type=large";
                            Log.d("Facebook ", "userId : " + userId);
                            final String token = loginResult.getAccessToken().getToken();
                            Log.d("Facebooklog ", "Token " + token);
                            if (profile == null) return;
                            String name = profile.getName();
                        }
                    };
                    mProfileTracker.startTracking();
                }

                @Override
                public void onCancel() {
                    Log.d("facebook - onCancel", "cancelled");
                }

                @Override
                public void onError(FacebookException e) {
                    Log.d("facebook - onError", e.getMessage());
                }
            });
        }
    });
}