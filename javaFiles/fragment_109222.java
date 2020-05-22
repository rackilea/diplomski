public class SelectiveAmqpPublisher extends SpringAMQPPublisher {


    static boolean shouldSend (Class<?> pt) {
        return PublicEvent.class.isAssignableFrom(pt);
    }


    public SelectiveAmqpPublisher (
            SubscribableMessageSource<EventMessage<?>> messageSource) {

        super(messageSource);

    }


    @Override
    protected void send (List<? extends EventMessage<?>> events) {

        super.send(events.stream()
                        .filter(e -> shouldSend(e.getPayloadType()))
                        .collect(Collectors.toList()));

    }    

}