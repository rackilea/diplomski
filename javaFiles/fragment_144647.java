private void startListening(boolean cipher) {
    Timber.v("Start listening for fingerprint input");
    mCancellationSignal = new CancellationSignal();
    if(cipher) {
        mFingerprintManager.authenticate(new FingerprintManagerCompat.CryptoObject(mCipher),
                0, mCancellationSignal, new FingerprintAuthentication(this), null);
    } else {
        setStage(Stage.CREDENTIALS);
    }
}