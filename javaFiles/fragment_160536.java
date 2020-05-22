public enum State {
    STATE1,STATE2(STATE1),STATE3(STATE1,STATE2);

    private State[] previousStates;

    private State(){

    }
    private State(State ...state) {
        this.previousStates =state;
    }

    public State transition(State state) throws Exception {
        for(State tmp: state.previousStates) {
            if (this == tmp) {
                return state;
            }
        }
        throw new Exception("Illegal state");

    }

}