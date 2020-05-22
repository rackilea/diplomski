public void executeMyLogic() {
    stateMachine.start()
    stateMachine.sendEvent(Event.E1);
    if (stateMachine.getExtendedState().getVariables().containsKey("hasError") {
      throw (RuntimeException)stateMachine.getExtendedState().getVariables().get("error")
    }
}