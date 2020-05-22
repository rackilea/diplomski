interface Strategy {
    void execute(Object param);
}

enum EVENT implements Strategy {
    SEQUENCE_START(10) {
        @Override
        public void execute(Object param) {
            // stuff happens here
        }
    },
    SEQUENCE_HALT(11) {
        @Override
        public void execute(Object param) {
            // stuff happens here
        }
    },
    SEQUENCE_AUTHORIZED(12) {
        @Override
        public void execute (Object param){
            // stuff happens here
        }
    };

    private final int id;

    EVENT(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}

public class Test {

    public void handledStack parse(IRPEventType buffer) {
        final int eventId =     Integer.parseInt(buffer.reader().parse("EventID"));
        for (EVENT event : EVENT.values()) {
            if (event.getId() == eventId) {
                event.execute(param);
                break;
            }
        }
    }
}