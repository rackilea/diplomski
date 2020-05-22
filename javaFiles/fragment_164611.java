ExecutorService service = Executors.newSingleThreadExecutor();
service.submit(new Runnable(){
    public void run(){
      while(true){
       try {
            doSomething();
       } catch (Exception e) {
           //log exception etc...
       }
   }
}
});