private void enableNotifications(BluetoothGattCharacteristic chrt) {
        bluetoothGatt.setCharacteristicNotification(chrt, true);
        for (BluetoothGattDescriptor descriptor : chrt.getDescriptors()){
            if (descriptor.getUuid().equals(UUID.fromString("00002902-0000-1000-8000-00805f9b34fb"))) {
                Log.i("INFO", "Found NOTIFICATION BluetoothGattDescriptor: " + descriptor.getUuid().toString());
                descriptor.setValue(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);
            }
        }
    }