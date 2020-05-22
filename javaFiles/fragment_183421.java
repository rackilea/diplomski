public class Base64JavaObjectMessageConverter extends AbstractMessageConverter {

    public Base64JavaObjectMessageConverter() {
        super(MimeTypeUtils.TEXT_PLAIN);
    }

    @Override
    protected boolean supports(Class<?> clazz) {
        return true;
    }

    @Override
    public Object convertFromInternal(Message<?> message, Class<?> targetClass) {
        byte[] messageBytes = Base64.getDecoder().decode( (byte[])message.getPayload() );
        return SerializationUtils.deserialize( messageBytes  );
    }

    @Override
    public Object convertToInternal(Object payload, MessageHeaders headers) {
        byte[] messageBytes = SerializationUtils.serialize( payload );
        return Base64.getEncoder().encode( messageBytes);
    }

}