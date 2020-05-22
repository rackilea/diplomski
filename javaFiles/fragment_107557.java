BluetoothGattCharacteristic tChar = syncService.getCharacteristic(SYNC_HEIGHT_INPUT_CHAR);
        if (tChar == null) throw new AssertionError("characteristic null when sync time!");

        // use one of them in regards of the Characteristic's property
        tChar.setWriteType(BluetoothGattCharacteristic.WRITE_TYPE_NO_RESPONSE);
        //tChar.setWriteType(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);


        tChar.setValue(/*another int*/, BluetoothGattCharacteristic.FORMAT_SINT32, 0);
        gatt.writeCharacteristic(tChar);