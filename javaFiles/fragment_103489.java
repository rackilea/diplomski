while (i < ret) {
    int len = ret - i;
    if (len >= 1) {
        runOnUiThread(new Runnable() {
            int value = (int)buffer[i];
            mResponseField.setText(String.valueOf(value));                   
        });
    }
    i += 1; // number of bytes sent from arduino
}