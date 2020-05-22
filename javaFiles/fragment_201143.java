GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);

if (GoogleSignIn.hasPermissions(account, Games.SCOPE_GAMES_LITE)) {
    onSignIn(account);
} else {
    signInClient
      .silentSignIn()
      .addOnCompleteListener(
          this,
          task -> {
            if (task.isSuccessful()) {
              onSignIn(task.getResult());
            } else {
              resetSignedIn();
            }
          });
}