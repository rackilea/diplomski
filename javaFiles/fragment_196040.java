public void onClickTemp(View view) {
    gettemp();
    // No value of "adata" or "data" is guaranteed here
}

public void gettemp() {
    pushcmd("T\n");
    serial.read(mCallback); // asynchronous callback
    // No value of "adata" or "data" is guaranteed here, either
}

UsbSerialInterface.UsbReadCallback mCallback = new UsbSerialInterface.UsbReadCallback() {
    @Override
    public void onReceivedData(byte[] arg0) {
        try {
            // Here, you are guaranteed some data
            String data = new String(arg0, "UTF-8");
            tvAppend(textView, "\n Measured temperature \n" + data);
        } catch (UnsupportedEncodingException e) {
            e.getStackTrace();
        }
    }
};