class MyProcessor extends Processor {

  public void process(Exchange exchange) throws Exception {
    String body = exchange.getIn().getBody(String.class); //Maybe you need some other type.
   //do your logic here
  }

}