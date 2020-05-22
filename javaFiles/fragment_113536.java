wifibox = (CheckBox)findViewById(R.id.checkBox1);
NetworkChangeReceiver receiver;
wifibox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {


@Override
public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
    if(buttonView.isChecked()) {
        // The receiver should get activated now.
        receiver = new NetworkChangeReceiver ();
        IntentFilter filter = new IntentFilter();
        filter.addAction("YOUR ACTION NAME");
        registerReceiver(receiver, filter);
    }
    else {
        //logic if receiver is not registered
    }
}