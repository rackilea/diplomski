SmsReceiver BR_smsreceiver = null;

onCreate(Bundle savedInstance){
....
BR_smsreceiver = new SmsReceiver();
BR_smsreceiver.setActivityHandler(this);
IntentFilter fltr_smsreceived = new     
IntentFilter("android.provider.Telephony.SMS_RECEIVED");
registerReceiver(BR_smsreceiver, fltr_smsreceived);
....
}