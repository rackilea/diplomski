interface MyStrategy {
  public void doStuff();
}

class MyLibraryUsingStrategy implements MyStrategy {
  public void doStuff() {
    // call the library
  }
}

class MyEmbeddedStrategy implements MyStrategy {
  public void doStuff() {
    // embedded code
  }
}