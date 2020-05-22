private void handleSignInResult(GoogleSignInResult result) {
       Log.d(TAG, "handleSignInResult:" + result.isSuccess());
       if (result.isSuccess()) {
           // Signed in successfolly, show authenticated UI.
       } 
   }