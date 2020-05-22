private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
  try {
      GoogleSignInAccount account = completedTask.getResult(ApiException.class);

      // Signed in successfully, start your activity here.

  } catch (ApiException e) {
      // The ApiException status code indicates the detailed failure reason.
      // Please refer to the GoogleSignInStatusCodes class reference for more information.
      Log.w(TAG, "signInResult:failed code=" + e.getStatusCode());
      updateUI(null);
  }
}