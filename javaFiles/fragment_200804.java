public class AndroidNfcCommunicator implements NfcCommunicator {
    private NfcReceiveCallback myCallback;
    private Activity myActivity;

    public AndroidNfcCommunicator(Activity activity) {
        this.myActivity = activity;
    }

    public void initialize() {
        // NFC initialization code if any.
    }

    public void sendData(Object data) {
        // Send data (you have access to android sdk here)
    }

    public void setReceiveCallback(NfcReceiveCallback callback) {
        this.myCallback = callback;
    }

    public void checkForReceivedData() {
        if (/* Data has been received (Use Activity object here. Since data comes from intent.)*/) {
            this.myCallback.execute(/* Pass data here. */);
        }
    }
}