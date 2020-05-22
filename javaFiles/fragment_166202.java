public class DatabaseSession {
    private State state;

    ...


    public makeCallOne() throws Exception {
        if (state == State.CLOSED)) {
            throw new Exception("Database Session has already been closed");
        }
        ...
    }
    public makeCallTwo() throws Exception {
        if (state == State.CLOSED)
            throw new Exception("Database Session has already been closed");
        }
        ...
    }

    public close() {
        state = State.CLOSED;
        ...
    }

    private enum State {
        OPEN;
        CLOSED;
    }