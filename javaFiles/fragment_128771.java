class MyFSM {

    enum State {
        FIRST_STATE {
            @Override
            void start(MyFSM fsm) {
                fsm.doStart();
            }
            @Override
            void stop(MyFSM fsm) {
                throw new IllegalStateException("Not Started!");
            }
        },
        SECOND_STATE {
            @Override
            void start(MyFSM fsm) {
                throw new IllegalStateException("Already Started!");
            }
            @Override
            void stop(MyFSM fsm) {
                fsm.doStop();
            }
        };

        abstract void start(MyFSM fsm);
        abstract void stop(MyFSM fsm);       
    }

    private volatile State state = State.FIRST_STATE;

    public synchronized void start() {
        state.start(this);
    }

    private void doStart() {
        state = SECOND_STATE;
    }

    public synchronized void stop() {
        state.stop(this);
    }

    private void doStop() {
        state = FIRST_STATE;
    }
}