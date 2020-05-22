public class NoopMessageConverter implements MessageConverter {
    @Override
    public Message toMessage(Object object, Session session) 
        throws JMSException, MessageConversionException {
        return (Message) object;
    }

    @Override
    public Object fromMessage(Message message) 
        throws JMSException, MessageConversionException {
        return message;
    }
}