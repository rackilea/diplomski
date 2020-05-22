Foo myFooInstance = new Foo();
String someValue = "value";
try {
  myFooInstance.bar(someValue);
} catch (IOException ioe) {
  /*handle file access problem*/
} catch (BooException boe) {
  /*handle user in wrong spot*/
} catch (BazException bze) {
  /*handle out-of-sync fatal error*/
} catch (Exception ex) {
  LogRecord lr = new LogRecord(Level.SEVERE, "Unhandled exception!! returning immediately!!");
  lr.setThrown(ex);
  lr.setParameters(new Object[]{someValue});
  Logger.getLogger(MyClass.class.getName()).log(lr);
  return;
}