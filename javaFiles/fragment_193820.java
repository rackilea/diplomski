private String orderId;
private AppNotificationReceiver receiver = new 
AppNotificationReceiver() {
@Override
public void onReceive(Context context, AppNotification notification) {
  log("Received " + notification);
orderId = notification.payload();
}
};

 @Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main);
//Register the receiver to your mainActivity
receiver.register(this);

}

  @Override
protected void onDestroy() {
super.onDestroy();
receiver.unregister();
}