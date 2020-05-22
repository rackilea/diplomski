@Override
public void onAuthenticationSucceeded(FingerprintManagerCompat.AuthenticationResult result) {
    try {
        mPassword = decryptPassword(result.getCryptoObject().getCipher());
    } catch (IllegalBlockSizeException | BadPaddingException exception) {
        exception.printStackTrace();
    }
}