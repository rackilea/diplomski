// Let's pretend this is called from our constructor.
private void initialize() {
  this.foo = goGetAFooFromLDAPOrSomething();
  // yay, now foo is set to something that I went and got from somewhere;
  // I just went out and got it; I didn't do anything fancy involving
  // CDI
}