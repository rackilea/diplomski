@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_blue_tooth_main);

    txtResults = (TextView) this.findViewById(R.id.txtResults);
    mBlueToothAdapter = BluetoothAdapter.getDefaultAdapter();

    …
}

@Override
protected void onResume() {
    super.onResume();
    if (!(mBlueToothAdapter.isEnabled())) { 
        //Take the user to settings first!
        Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
        startActivity(intent);
    } else {
        mBlueToothAdapter.startDiscovery();
    }
}