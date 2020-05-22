String  baseStr  = "/webapp";  //... contains: helloWorld.html, login.html, etc. and folder: other/xxx.html
    URL     baseUrl  = SplitFileServerRunner.class.getResource( baseStr ); 
    String  basePath = baseUrl.toExternalForm();

      .... 
    resource_handler.setDirectoriesListed(true);      //... just for testing
    resource_handler.setWelcomeFiles(new String[]{ "helloWorld.html" });
    resource_handler.setResourceBase( basePath );
    LOG.info("serving: " + resource_handler.getBaseResource());