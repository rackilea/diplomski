@Override
   public void onConnected(Bundle bundle) {

    // Update the user interface to reflect that the user is signed in.
    mSignInProgress = STATE_DEFAULT;

    if (BuildConfig.DEBUG) {
        Log.i(LOG_TAG, "Signed in");
    }
    final String accountName = Plus.AccountApi.getAccountName(mGoogleApiClient);
    credential.setSelectedAccountName(accountName); // private GoogleAccountCredential credential;


    // call your GAE stuff


    }