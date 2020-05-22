OptionalPendingResult<GoogleSignInResult> opr = Auth.GoogleSignInApi.silentSignIn(mGoogleApiClient);
if (opr.isDone()) {
    GoogleSignInResult signInResult = opr.get();
    GoogleSignInAccount account = result.getSignInAccount();
    String displayName = account.getDisplayName();
    String givenName = account.getGivenName();
    String familyName = account.getFamilyName();
}