...

private BluetoothAdapter.LeScanCallback mLeScanCallback =
        new BluetoothAdapter.LeScanCallback() {

            @Override
            public void onLeScan(final BluetoothDevice device, int rssi, byte[]   scanRecord) {

                // insert the device into the SQLite database
                String date = new SimpleDateFormat("ddMMyyHHmmss").format(new Date());
                myDb.insertData(device.getAddress(), device.getName() , date);

                // add device to list displayed on GUI
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mLeDeviceListAdapter.addDevice(device);
                        mLeDeviceListAdapter.notifyDataSetChanged();
                    }
                });
            }
        };

...