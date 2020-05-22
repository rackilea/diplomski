boolean invalidInput = false;
try (Scanner in = new Scanner(System.in)) {
  while (in.hasNextLine()) {
    do {
      String line = input.nextLine();
      invalidInput |= doSomethingWithALineOfInput(line);
      do {
        String line2 = input.nextLine();
        invalidInput |= doSomethingWithASecondLineOfInput(line2);
      } while (invalidInput);
    } while (invalidInput);
  }
}