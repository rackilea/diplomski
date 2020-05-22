public class Main {
    public static void main(String[] args) {
        WebTarget target = null;//...
        EventSource es = openAsynchronizely(target);

        es.register(new EventListener() {
            @Override
            public void onEvent(InboundEvent inboundEvent) {
                ///...
            }
        });
    }

    static EventSource openAsynchronizely(WebTarget target) {
        EventSource eventSource = new EventSource(target, false);
        new OpenThread(eventSource).start();
        return eventSource;
    }

    static class OpenThread extends Thread {
        private final EventSource eventSource;

        public OpenThread(EventSource eventSource) {
            this.eventSource = eventSource;
        }

        @Override
        public void run() {
            eventSource.open();
        }
    }
}