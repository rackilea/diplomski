public static class DTO {

    private Map<String, Object> inputMap;

    private Map<String, Object> outputMap;

    public Map<String, Object> getInputMap() {
        return this.inputMap;
    }

    public void setInputMap(Map<String, Object> inputMap) {
        this.inputMap = inputMap;
    }

    public Map<String, Object> getOutputMap() {
        return this.outputMap;
    }

    public void setOutputMap(Map<String, Object> outputMap) {
        this.outputMap = outputMap;
    }

    @Override
    public String toString() {
        return "DTO [inputMap=" + this.inputMap + ", outputMap=" + this.outputMap + "]";
    }

}

@RabbitListener(queues = QUEUE, containerFactory = "adapterOPListenerContainerFactory")
public void listen(HashMap<String, DTO> message) {
    System.out.println("Result:" + message.getClass() + ":" + message);
    latch.countDown();
}

@Bean
public SimpleRabbitListenerContainerFactory adapterOPListenerContainerFactory(ConnectionFactory connectionFactory) {
    SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
    factory.setConnectionFactory(connectionFactory);
    factory.setMessageConverter(new Jackson2JsonMessageConverter());
    return factory;
}