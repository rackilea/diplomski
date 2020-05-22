import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

public class MyListener implements MessageListener {

    @Override
    public void onMessage(Message message) {
        try {
            ObjectMessage mapMessage = (ObjectMessage) message;
            InstructionMessage instructionMessage = (InstructionMessage) mapMessage.getObject();
            System.out.println(instructionMessage.toString());
        } catch (NumberFormatException | JMSException e) {
            e.printStackTrace();
        }
    }
}