class Entity {
    private EnumSet<State> supportedStates;
    private State currentState;

    protected Entity(State... state) {
        states = EnumSet.copyOf(Arrays.asList(state));
    }

    //Assumes you are using these values elsewhere, otherwise - private
    public boolean isStateSupported(State state){
        return supportedStates.contains(state);
    }

    public void setCurrentState(State currentState){
        if(!isStateSupported(currentState){
             throw new IllegalStateException();
        }
        this.currentState = currentState;
    }
    public State getCurrentState(){
        return currentState;
    }
}