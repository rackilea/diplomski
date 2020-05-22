@EventListener(condition = "event.listenerId.startsWith('qux-')")
    public void idleEventHandler(ListenerContainerIdleEvent event) {

        // find new subscriptions
        Collection<EventListenerSubscription> newSubscriptions = 
                subscriptions.stream().filter(s -> s.isNew())
                .collect(Collectors.toList());

        if (!newSubscriptions.isEmpty()) {

            // mark subscriptions a not new
            newSubscriptions.forEach(s -> s.setNew(false));

            // compute the oldest time stamp
            OptionalLong oldestTimeStamp = 
                    newSubscriptions.stream()
                    .mapToLong(s -> s.getLastTimeStamp())
                    .reduce(Long::min);

            if (oldestTimeStamp.isPresent()) {

                // seek on topic for oldest time stamp
                Map<TopicPartition, Long> timestampsToSearch = new HashMap<>();
                timestampsToSearch.put(new TopicPartition(eventTopic, 0),
                                       oldestTimeStamp.getAsLong());
                Consumer<?, ?> consumer = event.getConsumer();
                event.getConsumer().offsetsForTimes(timestampsToSearch).forEach((k, v) -> {
                    consumer.seek(k, v.offset());
                });
            }
        }
    }