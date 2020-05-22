template.convertAndSend("", "myQueue", jsonString, new MessagePostProcessor() {

    @Override
    public Message postProcessMessage(Message message) throws AmqpException {
        message.getMessageProperties().setContentType("application/json");
        message.getMessageProperties().getHeaders()
            .put(AbstractJavaTypeMapper.DEFAULT_CLASSID_FIELD_NAME, "foo.SignUpDto");
        return message;
    }
});