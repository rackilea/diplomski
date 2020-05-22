try {
  int i = 5;
  myObject.calculate(5);
} catch(FooException ex) {
  // Print error and terminate application.
  ex.printStackTrace();
  System.exit(1);
} catch(IOException ex) {
  // Rethrow as FooException.
  throw new FooException(ex);
}