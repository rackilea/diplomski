final BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
final ImageView btImg = (ImageView) findViewById(R.id.bluestatus);

if (mBluetoothAdapter == null || !mBluetoothAdapter.isEnabled()) {
    btImg.setImageResource(R.drawable.notok);
} else {
    btImg.setImageResource(R.drawable.ok);
}