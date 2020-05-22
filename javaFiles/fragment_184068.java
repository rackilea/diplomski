@Override
public void onSignInSucceeded() {
   super.onSignInSucceeded();
   // allow to submit scores
}

@Override
public void onSignInFailed() {
    super.onSignInFailed();
    // do not allow to submit scores
}