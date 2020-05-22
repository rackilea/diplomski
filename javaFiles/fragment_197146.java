public void setCurrentState(State newState) {
    System.gc();
    currentState = newState;
    newState.init();
    inputHandler.setCurrentState(currentState);
}