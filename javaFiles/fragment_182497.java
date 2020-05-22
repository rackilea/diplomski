class SuperClass {
  public void onClick(){
    if(!disabled) handleOnClick();
  }
  public void handleOnClick(){
  }
}

class SubClass extends SuperClass {
  public void handleOnClick(){
    System.out.println("Clicked");
  }
}