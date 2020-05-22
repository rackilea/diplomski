@Override
public void onConnected(@Nullable Bundle bundle) {

    // Handle the silent sign-in case.

    if (mGoogleApiClient.hasConnectedApi(Games.API)) {
        Auth.GoogleSignInApi.silentSignIn(mGoogleApiClient).setResultCallback(
                new ResultCallback<GoogleSignInResult>() {
                    @Override
                    public void onResult(
                            @NonNull GoogleSignInResult googleSignInResult) {
                        if (googleSignInResult.isSuccess()) {
                            completePlayGamesAuth(
                                    googleSignInResult.getSignInAccount());
                        } else {
                            Log.e(TAG, "Error with silentSignIn: " +
                                    googleSignInResult.getStatus());
                        }
                    }
                }
        );
    }
}