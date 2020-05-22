CamelContext camelContext = new DefaultCamelContext();
    BasicConfigurator.configure();
    camelContext.addRoutes(new RouteBuilder() {

      public void configure() throws Exception {

        String publicKeyFileName = "file:C:\\LocalData\\Keys\\pgp_public.asc";
        String keyUserid = " ";

        from("file:C:\\Test\\Test\\IN")
            .log("file received")
            .marshal().pgp(publicKeyFileName, keyUserid)
        .to("file:C\\Test\\Test\\OUT");

      }
    });
    camelContext.start();
    Thread.sleep(30000);
    camelContext.stop();
  }