GoogleSignInResult result =    Auth.GoogleSignInApi.getSignInResultFromIntent(data);

if (result.isSuccess()) {
    GoogleSignInAccount acct = result.getSignInAccount();
    String idToken = acct.getIdToken();
}