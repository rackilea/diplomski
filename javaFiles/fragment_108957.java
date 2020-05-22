void doTheThing(Runnable r){
  r.run();
}

doTheThing(new Runnable(){
  public void run(){
    yourFunctionHere();
  }
});