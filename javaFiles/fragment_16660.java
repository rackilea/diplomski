private InputStream inputStream;
private Scanner input;

public InputReceiver() {
  inputStream = System.in;
  scanner = new Scanner(inputStream);
}

  // for unit testing
 InputReceiver(InputStream inputStream, String delimiter) {
  this.inputStream = inputStream;
  scanner = new Scanner(inputStream);
  scanner.useDelimiter(delimiter);
}