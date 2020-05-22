Class Example {
  private SomeObject obj;

  public void A() {
    obj = new Obj();
  }

  public SomeObject B(SomeObject obj) {
    this.obj = obj; // save the passed instance into the object
    return obj;
  }

  public void C() {
    obj.callSomeFunction(); // it'll still exist here, as long as you called A() before C()
  }
}