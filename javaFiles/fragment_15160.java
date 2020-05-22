@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main);
BluetoothAdapter myDevice = BluetoothAdapter.getDefaultAdapter();
String deviceName = myDevice.getName();
TextView tv = (TextView) findViewById(R.id.text1);
tv.setText(deviceName);
..
..
}