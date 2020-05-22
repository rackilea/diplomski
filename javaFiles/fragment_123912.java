RequestProcessor requestProcessor = new RequestProcessor() {

  @Override
  public void visit(Request request) {
    System.out.println("I'm a normal request");
  }

  @Override
  public void visit(SpecialRequest specialRequest) {
    System.out.println("I'm a special request");
  }
};


Request request = new Request();
request.accept(requestProcessor);

SpecialRequest specialRequest = new SpecialRequest();
specialRequest.accept(requestProcessor);