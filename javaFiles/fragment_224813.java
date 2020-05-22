try {
  myService.call(new RemoteCallback<Result>() {
    @Override
    public void callback(final Result result) {
      Window.alert("Yay, got a result: " + result);
    }
  },
  new BusErrorCallback() {
    @Override
    public boolean error(Message message, Throwable throwable) {
      Window.alert("Got an exception from the remote service: " + throwable);
      return false;
    }
  }).dangerousOperation();
}
catch (MyCheckedException e) {
  throw new AssertionError(); // can't happen: caller stub won't throw this
}