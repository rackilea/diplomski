public static final String LOGTAG = GoogleSignInActivity.TAG + "_OnResult";
public static GoogleSignInActivity.ShareStringCallback shareStringCallback;

private static final int RC_SIGN_IN = 9001;
private GoogleSignInClient mGoogleSignInClient;
private GoogleSignInOptions gso;

private CallbackManager mCallbackManager;

public void myFinish(String myresult) {

    if (shareStringCallback != null) {
        shareStringCallback.onLoginComplete(myresult);
    }

    shareStringCallback = null;
    finish();
}

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    Log.i(LOGTAG, "onCreateBundle");
    Intent intent = getIntent();

    setContentView(R.layout.login_activity);
    findViewById(R.id.buttonFacebookLogin).setOnClickListener(this);
    findViewById(R.id.signInButton).setOnClickListener(this);
    findViewById(R.id.buttonAnonymousSignIn).setOnClickListener(this);
}

/* GOOGLE SIGN-IN CODE */
public Intent StartGoogleLogin() {
    /*
    Google Sign In Client Init Code Goes Here
    */
    Intent signInIntent = mGoogleSignInClient.getSignInIntent();
    return signInIntent;
}

@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    //Detects some type of result from an activity, in this case Google
    String id_result = "Send This To Unity";
    myFinish(id_result);
}