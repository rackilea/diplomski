void foo() {
  if(bar()) {
    // branch is handled by bar
  } else {
    doSomethingElse();
  }
}

boolean bar() {
  if(somethingWrong) {
    return false;
  }
  doSomething();
}