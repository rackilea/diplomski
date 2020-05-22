private static final int PERMISSION_REQUEST = 100;

//this is the onclick listener of send button
public void send(View view) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        if (checkSelfPermission(Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {
            if (shouldShowRequestPermissionRationale(Manifest.permission.SEND_SMS)) {
                Snackbar.make(findViewById(R.id.rl), "You need to grant SEND SMS permission to send sms",
                        Snackbar.LENGTH_LONG).setAction("OK", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        requestPermissions(new String[]{Manifest.permission.SEND_SMS}, PERMISSION_REQUEST);
                    }
                }).show();
            } else {
                requestPermissions(new String[]{Manifest.permission.SEND_SMS}, PERMISSION_REQUEST);
            }
        } else {
            sendSMS();
        }
    } else {
        sendSMS();
    }
}

private void sendSMS() {
    String phoneNumber = "1234";
    String msg="hello, this is a text message";
    SmsManager sms = SmsManager.getDefault();
    sms.sendTextMessage(phoneNumber, null, msg, null, null);
}

@Override
public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
    super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {

        Snackbar.make(findViewById(R.id.rl), "Permission Granted",
                Snackbar.LENGTH_LONG).show();
        sendSMS();

    } else {

        Snackbar.make(findViewById(R.id.rl), "Permission denied",
                Snackbar.LENGTH_LONG).show();

    }
}