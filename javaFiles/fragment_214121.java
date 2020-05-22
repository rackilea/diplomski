public Class A implements Runnable {
    private static final ThreadLocal<Logger> logger = new ThreadLocal<Logger>(){
       //return your desired logger
       }

     @Override
     public void run() {
       //check condition and change logger if required
       //check if that particular servlet and user also 
        if (Thread.currentThread.getName().equals("something") && user.getId() ==XX) {
         ConsoleAppender a = (ConsoleAppender) Logger.getRootLogger().getAppender("stdout");
         a.setLayout(new PatternLayout("%d{HH:mm:ss}  %-5.5p  %t %m%n"));
       }
     }
  }