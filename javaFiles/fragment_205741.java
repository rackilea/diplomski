@Override
public void onDestroy() {
    super.onDestroy();
    Intent intent = new Intent();
    intent.setAction("com.example.broadcast.MY_NOTIFICATION");
    intent.putExtra("data","Notice for logout!");
    sendBroadcast(intent);
}