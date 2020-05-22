void someMethod() throws SomeException {    
  try {
    doSomethingElse()
  } catch (SomeException e) {
    // is this reached or does it throw from the method?
  }
}