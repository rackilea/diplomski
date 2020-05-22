public class Parent{
  public void method(String param){
    //Do stuff
  }

  private void notExtendable(String param){

  }

  protected void alsoExtendable(String param){

  }
}

public class SubClass extends Parent{
  @Override
  public void method(String param){
    //super.method() //if you want to execute parent's method
    //Do your own stuff
  }
}