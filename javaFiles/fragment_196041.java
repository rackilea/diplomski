public void onClickTemp(View view) {
    pushcmd("T\n");

    serial.read(new UsbSerialInterface.UsbReadCallback() {
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
    });
}