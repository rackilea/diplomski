@Override
public void onResume() {
    super.onResume();
    mFingerprintHandler.startListening();
}

@Override
public void onPause() {
    super.onPause();
    mFingerprintHandler.stopListening();
}