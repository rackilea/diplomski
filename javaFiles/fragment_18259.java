static void printMessage()
{
  System.out.println("Hello");
}

public static void main(String[] args) throws Exception
{
  // ByteArrayOutputStream = in-memory output stream
  OutputStream output = new ByteArrayOutputStream();
  PrintStream oldStream = System.out; // store the current output stream
  System.setOut(new PrintStream(output)); // change the output stream
  printMessage(); // call function that prints to System.out
  System.setOut(oldStream); // restore the old output stream
  System.out.println("Output from stream: " + output.toString());
}