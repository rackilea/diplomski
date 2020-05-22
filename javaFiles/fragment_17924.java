import android.content.Context;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Build;
import android.os.CancellationSignal;

public class FingerprintHandler {
    private Context                                     mContext;
    private FingerprintManager                          mFingerprintManager = null;
    private CancellationSignal                          mCancellationSignal;
    private FingerprintManager.AuthenticationCallback   mAuthenticationCallback;
    private OnAuthenticationSucceededListener           mSucceedListener;
    private OnAuthenticationErrorListener               mFailedListener;

    public interface OnAuthenticationSucceededListener {
        void onAuthSucceeded();
    }

    public interface OnAuthenticationErrorListener {
        void onAuthFailed();
    }

    public void setOnAuthenticationSucceededListener (OnAuthenticationSucceededListener listener){
        mSucceedListener = listener;
    }

    public void setOnAuthenticationFailedListener(OnAuthenticationErrorListener listener) {
        mFailedListener = listener;
    }

    public FingerprintHandler(Context context){
        mContext = context;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            mFingerprintManager = context.getSystemService(FingerprintManager.class);
            mCancellationSignal = new CancellationSignal();

            mAuthenticationCallback = new FingerprintManager.AuthenticationCallback() {
                @Override
                public void onAuthenticationError(int errorCode, CharSequence errString) {
                    super.onAuthenticationError(errorCode, errString);
                }

                @Override
                public void onAuthenticationHelp(int helpCode, CharSequence helpString) {
                    super.onAuthenticationHelp(helpCode, helpString);
                }

                @Override
                public void onAuthenticationSucceeded(FingerprintManager.AuthenticationResult result) {
                    super.onAuthenticationSucceeded(result);
                    if( mSucceedListener != null )
                        mSucceedListener.onAuthSucceeded();
                }

                @Override
                public void onAuthenticationFailed() {
                    super.onAuthenticationFailed();
                    if (mFailedListener != null)
                        mFailedListener.onAuthFailed();
                }
            };
        }
    }

    public void startListening(){
        if (isFingerScannerAvailableAndSet() ) {
            try{
                mFingerprintManager.authenticate(null, mCancellationSignal, 0 /* flags */, mAuthenticationCallback, null);
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public void stopListening(){
        if ( isFingerScannerAvailableAndSet() ) {
            try {
                mCancellationSignal.cancel();
                mCancellationSignal = null;
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public boolean isFingerScannerAvailableAndSet(){
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M)
            return false;
        if( mFingerprintManager == null )
            return false;
        if( !mFingerprintManager.isHardwareDetected() )
            return false;
        if( !mFingerprintManager.hasEnrolledFingerprints())
            return false;

        return true;
    }
}