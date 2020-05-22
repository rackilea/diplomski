public interface NfcCommunicator {
    public void initialize();
    public void sendData(Object data);
    public void setReceiveCallback(NfcReceiveCallback callback);
    public void checkForReceivedData();
}