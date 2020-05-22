@Test
public void shouldUseChildService() {
  ArgumentCaptor<Callable> callableCaptor = ArgumentCaptor.forClass(Callable.class);
  ArgumentCaptor<Consumer> consumerCaptor = ArgumentCaptor.forClass(Consumer.class);

  parentService.doAction();

  verify(worker).execute(callableCaptor.capture(), consumerCaptor.capture());
  callableCaptor.getValue().call(); //this will execute whatever was captured
  consumerCaptor.getValue().accept(null);//this will execute whatever was captured

  // now verify that childService::listClients and childService::refreshObjects have been called
}