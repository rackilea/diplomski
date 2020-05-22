@Override
    public void onDescriptorWriteRequest(BluetoothDevice device, int requestId, BluetoothGattDescriptor descriptor, boolean preparedWrite, boolean responseNeeded, int offset, byte[] value) {
        super.onDescriptorWriteRequest(device, requestId, descriptor, preparedWrite, responseNeeded, offset, value);

        Log.i(TAG, "onDescriptorWriteRequest, uuid: " + descriptor.getUuid());

        if (descriptor.getUuid().equals(Descriptor.CLIENT_CHARACTERISTIC_CONFIGURATION) && descriptor.getValue().equals(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE)) {
            Log.i(TAG, "its a subscription!!!!");

            for (int i = 0; i < 30; i++) {
                descriptor.getCharacteristic().setValue(String.format("new value: %d", i));
                mGattServer.notifyCharacteristicChanged(device, descriptor.getCharacteristic(), false);
            }
        }
    }