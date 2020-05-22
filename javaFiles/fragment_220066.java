final ByteArrayOutputStream myOut = new ByteArrayOutputStream();
System.setOut(new PrintStream(myOut));

// test stuff here...

final String standardOutput = myOut.toString();