// Setting up the proxy
          MobileProxy proxy = new MobileProxy("name",
                      8080, "XXX "XXX");
          DesiredCapabilities capabilities = new DesiredCapabilities();
          capabilities.setCapability(CapabilityType.PROXY, proxy);
          MobileDriver connector = new MobileDriver(capabilities);
          System.out.println("Script started");