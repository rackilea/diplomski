StateMachine<Status, Event> build(long orderId) {
  orderService.getOrder(orderId) //returns Optional
  .map(order -> {
     StateMachine<Status, Event> sm = stateMachineFactory.getStateMachine(Long.toString(orderId));
     sm.stop();
     rehydrateState(sm, sm.getExtendedState(), order.getStatus());
     sm.start();
     return sm;
   })
  .orElseGet(() -> createNewStateMachine(orderId);
}


void rehydrateState(StateMachine<Status, Event> newStateMachine, ExtendedState extendedState, Status orderStatus) {
  newStateMachine.getStateMachineAccessor().doWithAllRegions(sma ->
   sma.resetStateMachine(new DefaultStateMachineContext<>(orderStatus, null, null, extendedState));
  });
}