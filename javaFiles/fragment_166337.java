class Builder{
  public void act() {
    processRunner.runAsync(new ProcessRunner.ProcessResultHandler(){
      @Override
      public void onComplete(int result) {
        // Emit event
        Communicatort.getCommunicator().emitEventItem();
      }
    });
  }
  }