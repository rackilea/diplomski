interface StateEventListener {
    void onEventX();
    void onEventY(int x, int y);
    void onEventZ(String s);
}

enum State implements StateEventListener {
    initialState {
        @Override public void onEventX() {
            // do whatever
        }
        // same for other events
    },
    // same for other states
}

class StateMachine implements StateEventListener {
    State currentState;

    @Override public void onEventX() {
        currentState.onEventX();
    }

    @Override public void onEventY(int x, int y) {
        currentState.onEventY(x, y);
    }

    @Override public void onEventZ(String s) {
        currentState.onEventZ(s);
    }
}