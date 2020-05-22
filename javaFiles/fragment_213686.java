private void sendHelloWorld() {
    Map<String, String> subPayload = new HashMap<>();
    subPayload.put("test1", "value2");
    subPayload.put("test2", "value3");
    Map<String, Object> payload = new HashMap<>();
    payload.put("message", "Hello World!");
    payload.put("context", "Something");
    payload.put("map", subPayload);
    jmsTemplate.setMessageConverter(new MappingJackson2MessageConverter());
    jmsTemplate.convertAndSend( "notification/prediction", payload );
}