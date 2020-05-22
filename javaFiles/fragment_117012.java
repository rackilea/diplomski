if(tryCount >= 4)
    {
        tryCount = 0;

        Message msg = mHandler.obtainMessage(MainActivity.MESSAGE_TOAST);
        Bundle bundle = new Bundle();
        bundle.putString(MainActivity.TOAST, mContext.getResources().getString(R.string.cant_connect));
        msg.setData(bundle);
        mHandler.sendMessage(msg);

        BluetoothService.this.start();
    }
    else
    {
        tryCount++;
        connect(bluetoothDevice);
    }