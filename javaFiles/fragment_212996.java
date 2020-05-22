public class RecorderFactory {
    public EventList get() {
        return Recorder.getRecorders();
    }
}

public class TheOneThatContainsThePostMethod {
    private RecorderFactory recorderFactory;

    public TheOneThatContainsThePostMethod(RecorderFactory recorderFactory) {
        this.recorderFactory = recorderFactory;
    }

    public post(String json) {
        EventList list = recorderFactory.getRecorders();
        ...
    }
}

// Or ...

public post(String json, RecorderFactory recorderFactory) {
    EventList list = recorderFactory.getRecorders();
    ...
}