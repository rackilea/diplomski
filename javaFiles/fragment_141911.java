class Instance {
  private int prop;

  public Instance(int prop) {
    this.prop = prop;
  }


  public int getProp() {
    return prop;
  }
}

class MyInstance extends Instance {
  private Instance delegate;
  private int prop2;

  public MyInstance(Instance delegate, int prop2) {
    super(prop);
    this.delegate = delegate;
    this.prop2 = prop2;
  }

  @Override
  public int getProp() {
    return delegate.getProp();
  }

  public int getProp2() {
    return prop2;
  }

  public void foster(Instance i) {
    delegate = i;
  }
}

MyInstance foo = new MyInstance(1, 2);

Instance foster = new Instance(3);

//what i want to do
foo.adoptedBy(foster);
//with the result that foo.getProp() == 3