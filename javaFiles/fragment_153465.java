public void printBillToDevice(final String address) {
        mBTAdapter.cancelDiscovery();
        try {           BluetoothDevice mdevice = mBTAdapter.getRemoteDevice(address);
            Method m = mdevice.getClass().getMethod("createRfcommSocket",
                    new Class[] { int.class });
            mBTSocket = (BluetoothSocket) m.invoke(mdevice, 1);
            mBTSocket.connect();
            OutputStream os = mBTSocket.getOutputStream();
            os.flush();
            os.write(BILL.getBytes());
            System.out.println(BILL);
            if (mBTAdapter != null)
                mBTAdapter.cancelDiscovery();
            mBTSocket.close();
            setResult(RESULT_OK);
        } catch (Exception e) {
            Log.e("Class ", "My Exe ", e);
            // Toast.makeText(BluetoothPrint.this, ERROR_MESSAGE,
            // Toast.LENGTH_SHORT).show();
            e.printStackTrace();
            setResult(RESULT_CANCELED);
        }
    }