//Get SMS message data from SmsBroadcastReceiver
SmsBroadcastReceiver.bindListener(new SmsListener() {
    @Override
    public void messageReceived(String messageSender, String messageText) {
        //TODO: do something in here
        ....
});