@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        IntentFilter filter = new IntentFilter("SOMEACTION");
        this.registerReceiver(mReceiver , filter); 
        }

        @Override
        public void onDestroy() {
            super.onDestroy();
            this.unregisterReceiver(this.mReceiver );
        }

        private BroadcastReceiver mReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                if (intent.getAction() == "SOMEACTION") {
                     // retrieve the 4th int value and update something in MainActivity
                }
            }
        };