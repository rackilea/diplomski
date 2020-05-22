private boolean mReturningWithResult = false;

@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    mReturningWithResult = true;
}

@Override
protected void onPostResume() {
    super.onPostResume();
    if (mReturningWithResult) {
        // Commit your transactions here.
    }
    // Reset the boolean flag back to false for next time.
    mReturningWithResult = false;
}