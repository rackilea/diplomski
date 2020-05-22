Button or_email;
CallbackManager  mFacebookCallbackManager;
private AccessTokenTracker accessTokenTracker;
private ProfileTracker mProfileTracker;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    FacebookSdk.sdkInitialize(getApplicationContext());
    setContentView(R.layout.activity_main);

    mFacebookCallbackManager = CallbackManager.Factory.create();
    accessTokenTracker = new AccessTokenTracker() {
        @Override
        protected void onCurrentAccessTokenChanged(AccessToken oldToken, AccessToken newToken) {

        }
    };
    accessTokenTracker.startTracking();

    LoginButton mFacebookSignInButton = (LoginButton)findViewById(R.id.fb_login_btn);
    mFacebookSignInButton.setReadPermissions(Arrays.asList(
            "public_profile", "email", "user_birthday", "user_friends"));
    mFacebookSignInButton.registerCallback(mFacebookCallbackManager, callback);

    or_email = (Button)findViewById(R.id.or_email);

    or_email.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent i = new Intent(MainActivity.this, Register.class);
            MainActivity.this.startActivity(i);
        }


    });

}

 private FacebookCallback<LoginResult> callback = new FacebookCallback<LoginResult>() {

    @Override
    public void onSuccess(LoginResult loginResult) {
        try {
            if (Profile.getCurrentProfile() == null) {
                mProfileTracker = new ProfileTracker() {
                    @Override
                    protected void onCurrentProfileChanged(Profile profile_old, Profile profile_new) {
                        profile = profile_new;
                        Log.v("facebook - profile", profile_new.getFirstName());
                        mProfileTracker.stopTracking();
                    }
                };
                mProfileTracker.startTracking();
            } else {
                profile = Profile.getCurrentProfile();
                Log.v("facebook - profile", profile.getFirstName());
            }
            Intent intent = new Intent(getApplicationContext(), Register.class);
            startActivity(intent);
            finish();
        } catch (Exception e) {
            Log.d("ERROR", e.toString());
        }
    }

    @Override
    public void onCancel() {
        Toast.makeText(getApplicationContext(), "Cancelled", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onError(FacebookException e) {
        Log.d("FACEBOOK ERRROR", e.toString());
        Toast.makeText(getApplicationContext(), "Something went wrong!! Please try again", Toast.LENGTH_LONG).show();
    }
};


 @Override
protected void onActivityResult(int requestCode, int responseCode, Intent intent) {
    super.onActivityResult(requestCode, responseCode, intent);
    mFacebookCallbackManager.onActivityResult(requestCode, responseCode, intent);
}