private void sendSms(String phonenumber,String message, boolean isBinary)
{
    SmsManager manager = SmsManager.getDefault();

    PendingIntent piSend = PendingIntent.getBroadcast(this, 0, new Intent(SMS_SENT), 0);
    PendingIntent piDelivered = PendingIntent.getBroadcast(this, 0, new Intent(SMS_DELIVERED), 0);

    if(isBinary)
    {
            byte[] data = new byte[message.length()];

            for(int index=0; index<message.length() && index < MAX_SMS_MESSAGE_LENGTH; ++index)
            {
                    data[index] = (byte)message.charAt(index);
            }

            manager.sendDataMessage(phonenumber, null, (short) SMS_PORT, data,piSend, piDelivered);
    }
    else
    {
            int length = message.length();

            if(length > MAX_SMS_MESSAGE_LENGTH)
            {
                    ArrayList<String> messagelist = manager.divideMessage(message);

                    manager.sendMultipartTextMessage(phonenumber, null, messagelist, null, null);
            }
            else
            {
                    manager.sendTextMessage(phonenumber, null, message, piSend, piDelivered);
            }
    }
}