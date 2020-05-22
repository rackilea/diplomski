SmsManager sms = SmsManager.getDefault();
                                    // if message length is too long messages are divided
                                    List<String> messages = sms.divideMessage(message);
                                    for (String msg : messages) {

                                        PendingIntent sentIntent = PendingIntent.getBroadcast(context, 0, new Intent("SMS_SENT"), 0);
                                        PendingIntent deliveredIntent = PendingIntent.getBroadcast(context, 0, new Intent("SMS_DELIVERED"), 0);
                                        sms.sendTextMessage(phone, null, msg, sentIntent, deliveredIntent);

                                        Toast.makeText(context, "SMS Sent to: " + number, Toast.LENGTH_SHORT).show();
 }