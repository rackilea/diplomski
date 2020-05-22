MyResult generateResults(Bar bar) {
  // Setup code
  Set<SomeReturnType> valuesReturned = new LinkedHashSet<>();
  // …
  // loop
  {
    // stuff
    // … exceptions in this method should throw except for this one external code call
    try {
      valuesReturned.add(externalCodeCallGetSomeReturnValue(bar));
    }
    catch( RuntimeException | ExecutionException | InterruptedException e) {
      // In Java 8 you would say: new MyResult(valuesReturned, ()->{ throw e });
      return new MyResult(valuesReturned, new ReThrower() {
        public void reThrow()
            throws RuntimeException, ExecutionException, InterruptedException {
          throw e;
        }
      });
    }
    //...
  }
  return new MyResult(valuesReturned, null);
}