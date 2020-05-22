package learning.jms;


import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;



@MessageDriven(activationConfig = {
        @ActivationConfigProperty(propertyName = "destinationLookup",
            propertyValue = "queues/myQueue"),
        @ActivationConfigProperty(propertyName = "destinationType",
            propertyValue = "javax.jms.Queue"),
        @ActivationConfigProperty(propertyName = "messageSelector",propertyValue = "type=3")
    })
public class ListenerThree implements MessageListener {

    @Override
    public void onMessage(Message msg) {
        try {
            System.out.println("Msg received by typeThree: " + msg.getBody(String.class) + " type: " + msg.getIntProperty("type"));
        } catch (JMSException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}