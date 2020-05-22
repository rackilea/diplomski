try (Scanner in = new Scanner(System.in)) {
  while (in.hasNextLine()) {
    String line = in.nextLine();
    doSomethingWithALineOfInput(line);
  }
}