return new SimpleForwardingServerCallListener<ReqT>(next.startCall(call, headers)) {
  @Override 
  public void onMessage(ReqT request) {
    // TODO:validate request
    super.onMessage(request);
  }
};