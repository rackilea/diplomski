public class TheOneThatContainsThePostMethod {
    private EventList eventList;

    public TheOneThatContainsThePostMethod(EventList eventList) {
        this.eventList = eventList;
    }

    public post(String json) {
        if (null == this.eventList || this.eventList.isEmpty()) {
            throw new ServiceUnavailableException("An Recorder is either not configured");
        }
    }
}