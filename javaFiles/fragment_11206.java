@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
       setContentView(R.layout.fragment_firebase_games_signin);

     String webclientId = getString(R.string.web_client_id);

    GoogleSignInOptions options =
            new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_GAMES_SIGN_IN)
                    .requestServerAuthCode(webclientId)
                    .requestEmail()
                    .requestIdToken()
                    .build();

    mGoogleApiClient = new GoogleApiClient.Builder(this)
            .addApi(Games.API).addScope(Games.SCOPE_GAMES)
            .addApi(Auth.GOOGLE_SIGN_IN_API, options)
            .addConnectionCallbacks(this)
            .build();

}