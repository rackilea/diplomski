private final BroadcastReceiver mHandleMessageReceiver = new 
BroadcastReceiver() {
    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle = 
            intent.getExtras().getBundle("bundle_key_for_intent");
            if(bundle!=null){
                String edttext = bundle.getString("edttext");
            }
            //you can call any of your methods for using this bundle for your use case
    }
};