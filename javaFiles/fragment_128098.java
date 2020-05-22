from("ftp://Mike@localhost").to("file://someDirPath").marshal(xmlJsonFormat).process(
    new Processor() {
      public void process(Exchange exchange) throws Exception {
          String payload = exchange.getIn().getBody(String.class);
          // create the User object and set in  the body
          exchange.getIn().setBody(userObject);} });