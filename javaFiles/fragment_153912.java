Selenium sel;
    int port=9999;
    public static SeleniumServer server;
        public void startSeleniumServer() throws Exception {
           try {
            ServerSocket serverSocket = new ServerSocket(port);
            serverSocket.close();
                    //Server not up, start it
                    try {
                     RemoteControlConfiguration rcc = new RemoteControlConfiguration();
                     rcc.setPort(port);
                     server = new SeleniumServer(false, rcc);

                    } catch (Exception e) {
                        System.err.println("Could not create Selenium Server because of: "
                                + e.getMessage());
                        e.printStackTrace();
                    }
                    try {
                        server.start();
                        System.out.println("Server started");
                    } catch (Exception e) {
                        System.err.println("Could not start Selenium Server because of: "
                                + e.getMessage());
                        e.printStackTrace();
                    }
                } catch (BindException e) {
                    System.out.println("Selenium server already up, will reuse...");
                }
        }

        public void stopSeleniumServer(){
            if (server != null)
              {
                 try
                 {
                    server.stop();

                 }
                 catch (Exception e)
                 {
                    e.printStackTrace();
                 }
              }
            System.out.println("Selenium server stopped..");
        }

    public void startSeleniumRC() throws Exception{
        sel=new DefaultSelenium("localhost",
                port,
                "*firefox",
                "http://www.google.com");
        sel.start();
    }

    public void stopSeleniumRC()
    {
        sel.shutDownSeleniumServer();
    }