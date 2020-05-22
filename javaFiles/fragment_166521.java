try {
  // some code that may raise an exception
} catch (SomeException e ) {
  // any code you like here, which may be a call to a method of any object
  MyHandler h = new MyHandler();
  h.handleIt(e);
}