@Test
private void testSth() {        
  when(mockDisplay.getSuppliersEmails()).thenReturn("address@domain.com");
  when(mockDisplay.getTaskDescription()).thenReturn("This is the task to do");

  negotiationPresenter.onSubmit();

  verify(mockRpcService).startTask(any(NegotiationRequest.class),
                                   any(AsyncCallback.class));      
}