@Override
public void onConnectionFailed(ConnectionResult result) {
    // Always assign result first
    mConnectionResult = result;

    if (!result.hasResolution()) {
        GooglePlayServicesUtil.getErrorDialog(result.getErrorCode(), this,
                0).show();
        return;
    }

    if (!mIntentInProgress) {

        if (mSignInClicked) {
            // The user has already clicked 'sign-in' so we attempt to
            // resolve all
            // errors until the user is signed in, or they cancel.
            resolveSignInError();
        }
    }
}