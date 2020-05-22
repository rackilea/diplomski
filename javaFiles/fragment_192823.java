PrintStream myOut = null;
// Decide output method somehow
if(...) {
  myOut = System.out;
}
else {
  myOut = new PrintStream(new File("/path/to/a/file"));
}

// Use the PrintStream to write a message
myOut.println("Hello World");

// Tidy up at end
myOut.close();