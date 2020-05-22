public class Child {
  public static void main(String[] args) throws InterruptedException {
    Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
    logger.setLevel(Level.WARNING);
      try {
          GlobalScreen.registerNativeHook();
      }
      catch (NativeHookException ex) {
          System.err.println("There was a problem registering the native hook.");
          System.err.println(ex.getMessage());

          System.exit(1);
      }

      GlobalKeyListener globalkeylistener = new GlobalKeyListener();
      GlobalScreen.addNativeKeyListener(globalkeylistener);
      synchronized(globalkeylistener) {
        while(true){
            int list1itemCount = globalkeylistener.arrayList1.size();
            if (list1itemCount >= 4) {
                System.out.println(list1itemCount);
            }
            globalkeylistener.wait();
        }
      }
  }
}