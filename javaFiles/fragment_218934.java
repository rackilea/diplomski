DeferredCommand.addCommand(new Command(){
  @Override
  public void execute(){
    map.checkResizeAndCenter();
  }
});