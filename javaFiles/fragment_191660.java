@Override
public void onCreate() {
    super.onCreate();
    broadcaster = LocalBroadcastManager.getInstance(this);

}

   private void sendResult() {
    Intent intent = new Intent("sendResult");
    sendLocationBroadcast(intent);
}

private void sendLocationBroadcast(Intent intent){
    LocalBroadcastManager.getInstance(this).sendBroadcast(intent);