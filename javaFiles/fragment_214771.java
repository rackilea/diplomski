interface ConListener {
   void Connected();
   void DataSent(int size);
}

// Having it as a class, so that I can only add stub codes,
// for a particular method and leave the rest.

class TestListener implements ConListener {
   void Connected() {Assert.fail("")}
   void DataSent(int size) {Assert.fail("")}
}


@Test
public void SomeTest() {
   CompletableFuture<Void> connected = new CompletableFuture<Void>();
   mock = EasyMock.createMock(ConListener.class);

   // Record
   mock.Connected();
   EasyMock.expectLastCall().andDelegateTo(new TestListener() {
      public void Connected() {
        connected.complete(null);
      }
   });
  EasyMock.expectLastCall().times(1); // This cannot come before adding delegates. Why?
  EasyMock.replay(mock);

  // Test
  sock = createCon(addr, mock/*using actual mock*/);
  connected.get(timeout, unit);
  sock.send(blahblah);  

}