@Inject
Foo foo;

public void doSomething() {
  if (foo instanceof WeldClientProxy) {
    // foo is a proxy
  } else {
    // not a proxy
  }
}