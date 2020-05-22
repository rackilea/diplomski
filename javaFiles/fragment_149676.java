mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

    @Override
    public void onVerificationCompleted(PhoneAuthCredential credential) {
        //No need to authenticate again, just react to verified number
        //signInWithPhoneAuthCredential(credential);
    }

    @Override
    public void onVerificationFailed(FirebaseException e) {

        if (e instanceof FirebaseAuthInvalidCredentialsException) {

        } else if (e instanceof FirebaseTooManyRequestsException) {

        }

    }

    @Override
    public void onCodeSent(String verificationId,
                           PhoneAuthProvider.ForceResendingToken token) {

        mVerificationId = verificationId;
        mResendToken = token;

    }
};