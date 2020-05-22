@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
  LocalBroadcastManager.getInstance(this).registerReceiver(
                mMessageReceiver, new IntentFilter("listen_test"));
     }

  private BroadcastReceiver mMessageReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            // TODO Auto-generated method stub

            String content = intent.getStringExtra("content");
             //log content

           Log.e("tag", "listen: "+content,null );
        }
    };