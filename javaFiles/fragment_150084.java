private DelegationInterface delegate;

public void begin(DelegationInterface delegate) {
   this.delegate = delegate;
   myThread.start();
}