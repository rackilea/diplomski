Runtime.getRuntime().addShutdownHook(new Thread("Chatlog Shutdown Thread"){
  @Override
  public void run(){
    myLogFileHelper.tryClose();
  }
});