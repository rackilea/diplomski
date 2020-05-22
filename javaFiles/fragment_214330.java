void foo() {
  try {
    bar()
  } catch(SomeException e) {
    doSomethingElse();
  }
}

boolean bar() {
  if(somethingWrong) {
    throw new SomeException();
  }
  doSomething();
}