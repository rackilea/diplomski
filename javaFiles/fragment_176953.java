public class MyMessagePostProcessor implements MessagePostProcessor {

    private final Integer ttl;

    public MyMessagePostProcessor(final Integer ttl) {
        this.ttl = ttl;
    }

    @Override
    public Message postProcessMessage(final Message message) throws AmqpException {
        message.getMessageProperties().getHeaders().put("expiration", ttl.toString());
        return message;
    }
}