try {
  // Some code ...
}
catch(SomeException e1) {
  // SomeException code ...
}
catch(SomeOtherException e2) { // SomeOtherException is NOT SomeException extension
  throw new myException("whatever message required");
}
finally {
  // Some final code ...
}