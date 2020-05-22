IPAccessHandler ipBlockingHandler = new IPAccessHandler(){
      @Override
      protected boolean isAddrUriAllowed(String addr,
                               String path){
          return addr.equals("127.0.0.1") || addr.equals("0:0:0:0:0:0:0:1");
      }
    };