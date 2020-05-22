public void scan(CallbackContext context) {
    this.callbackContext = context;
    IntentFilter filter = new IntentFilter();
    filter.addAction("action_barcode_broadcast");

    if (this.receiver == null) {
        this.receiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                 if(intent.getAction().equals("action_barcode_broadcast")) {
                     strBarcode = intent.getExtras().getString("key_barcode_string");
                     callbackContext.success(strBarcode);
                 }
             }

         };
         cordova.getActivity().startService(intentService);
         cordova.getActivity().registerReceiver(this.receiver, filter);
     }
 }