import org.springframework.jms.core.JmsTemplate;

public class SpringJmsPersonProducer {

    private JmsTemplate jmsTemplate;

    public JmsTemplate getJmsTemplate() {
        return jmsTemplate;
    }

    public void setJmsTemplate(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void sendMessage(final InstructionMessage instructionMessage) {
        if (canSend(instructionMessage)) {
            getJmsTemplate().convertAndSend(instructionMessage);
        } else {
            throw new IllegalArgumentException("message");
        }
    }

    private boolean canSend(InstructionMessage instructionMessage) {
        return instructionMessage.getQuantity() > 0;
    }
}