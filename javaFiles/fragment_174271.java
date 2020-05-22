@KafkaListener(id = "qux", topics = { "${app.event.topic}" }, errorHandler = "kafkaListenerErrorHandler")
    public void receive(@Payload Event event, @Headers MessageHeaders headers) throws JsonProcessingException {

        // collect the subscribers not marked as new
        Collection<EventListenerSubscription> oldSubscriptions = 
                subscriptions.stream().filter(s -> !s.isNew())
                .collect(Collectors.toList());

        for (EventListenerSubscription s : oldSubscriptions) {
            if (s.getLastTimeStamp() < timestamp) {
                s.addMessage(event, timestamp);
            }
        }
    }