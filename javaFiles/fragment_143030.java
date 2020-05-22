public interface EventProcessor {
    public boolean supports(Event event, User user);
    public void handleEvent(Event event);
}

class EventProcessorFactory {
    public void setEventProcessors(List<EventProcessor> processors) {
        this.processors = processors;
    }
    public EventProcessor get(Event event, User user) {
        for (EventProcessor processor : processors) {
            if (processor.supports(event, user)
                return processor;
        }
    }
}

class LocalEventProcessor implements EventProcessor {
   public boolean supports(Event event, User user) {
        return (event instanceof LocalEvent);
   }
   // etc
}

class RemoteEventProcessor implements EventProcessor {
    public boolean supports(Event event, User user) {
        return (event instanceof RemoteTriggeredEvent) &&
               (user instanceof AdminUser);
    }
    // etc
}