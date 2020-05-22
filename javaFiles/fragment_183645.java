private class BackgroundThread1 extends HandlerThread {
    public BackgroundThread1() {
        super();
         ...
          Some code
         ...
        start();
        b1Handler = new MessageHandler(getLooper()); 
            // this is the main thread here... but you create the handler with the looper of the new thread!
    }
    ...
}