@Override
    protected void onHandleIntent(Intent intent) {
    String username = intent.getStringExtra("username");
    String password = intent.getStringExtra("password");
    ...
}