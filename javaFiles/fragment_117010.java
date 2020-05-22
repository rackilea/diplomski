if (bluetoothLostReceiver == null)
        {
            bluetoothLostReceiver = new BluetoothLostReceiver();
            bluetoothLostReceiver.setMainActivity(this);
            IntentFilter filter = new IntentFilter("android.bluetooth.device.action.ACL_DISCONNECTED");
            registerReceiver(bluetoothLostReceiver, filter);
        }