private final BroadcastReceiver broadcastReceiver1=new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action=intent.getAction();
            if(BluetoothAdapter.ACTION_DISCOVERY_FINISHED.equals(action)){
                if(deviceFound==false) {
                    bluetoothAdapter.cancelDiscovery();
                    bluetoothAdapter.startDiscovery();
                }
            };
        }
    };
private final BroadcastReceiver broadcastReceiver=new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action=intent.getAction();

            if(BluetoothDevice.ACTION_FOUND.equals(action)){
                BluetoothDevice device=intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                String deviceName=device.getName();
                String deviceHardwareAddress=device.getAddress();
                int rssi=intent.getShortExtra(BluetoothDevice.EXTRA_RSSI,Short.MIN_VALUE);
                if(deviceHardwareAddress.equals(MAC)){
                    deviceFound=true;
                    bluetoothAdapter.cancelDiscovery();
                    Log.i("broadcastReceiver" , "device " + deviceName);
                    Log.i("broadcastReceiver" , "hard"  + deviceHardwareAddress);
                    Log.i("broadcastReceiver","Rssi "+rssi);
                    Log.i("broadcastReceiver","Paired Id "+MAC );
                    tv.setText(deviceName+"     "+rssi);
                    deviceFound=false;
                    bluetoothAdapter.startDiscovery();
                }
            }

        }
    };