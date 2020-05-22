private StateMachineListenerAdapter<State, Event> customListener() {
  return new StateMachineEventListenerAdapter<State, Event>() {

    @Override
    public void eventNotAccepted(Message event) {
      //LOG which event was not accepted etc.
    }
  }
}