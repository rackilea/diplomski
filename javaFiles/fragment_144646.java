public class FingerprintAuthentication extends FingerprintManagerCompat.AuthenticationCallback {

    private final Callback mCallback;

    public FingerprintCallback(Callback callback) {
        mCallback = callback;
    }

    @Override
    public void onAuthenticationSucceeded(FingerprintManagerCompat.AuthenticationResult result) {
        mCallback.onAuthenticationSucceeded(result);
    }

    @Override
    public void onAuthenticationHelp(int messageId, CharSequence message) {
        mCallback.onAuthenticationHelp(messageId, message);
    }

    @Override
    public void onAuthenticationError(int messageId, CharSequence message) {
        mCallback.onAuthenticationError(messageId, message);
    }

    @Override
    public void onAuthenticationFailed() {
        mCallback.onAuthenticationFailed();
    }

    public interface Callback {

        void onAuthenticationSucceeded(FingerprintManagerCompat.AuthenticationResult result);

        void onAuthenticationHelp(int messageId, CharSequence message);

        void onAuthenticationError(int messageId, CharSequence message);

        void onAuthenticationFailed();
    }
}