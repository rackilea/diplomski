public class MyMessageListener implements OutboundMessageListener
{
    public void notifyOutgoingMessage(javax.wireless.messaging.Message m)
    {
        try {
            String msg = null;
            msg = getMessage(m); // my call to convert Message to String
            //... process msg
        }
        catch(Exception ex) {
            // handle exception
        }
    }

    public void notifyIncomingMessage(MessageConnection conn) 
    {
        // handle received sms here
    }
}