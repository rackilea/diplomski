private void location(String phoneNumber, Location currentLocation) {
    try {
        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(phoneNumber, null, "maps.google.com?q=" + currentLocation.getLatitude() + "," + currentLocation.getLongitude(), null, null);
        Toast.makeText(getApplicationContext(), "SMS Sent!",
                Toast.LENGTH_LONG).show();
    } catch (Exception e) {
        Toast.makeText(getApplicationContext(),
                "SMS faild, please try again later!",
                Toast.LENGTH_LONG).show();
        e.printStackTrace();
    }
}