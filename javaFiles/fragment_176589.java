class MyClass {
  public MyClass() {
    do_thingsMC();   
  }
  public void do_things()  {
     do_thingsMC();
  }
  protected void do_thingsMC()  {
     //Do super-things only
  }
}

class MyOther extends MyClass {
  public MyOther() {
     super();
     do_thingsMO();
  }
  public void do_things()  {
     super.do_things();
     do_thingsMO();
  }
  protected void do_thingsMO()  {
     //Do sub-things only
  }
}