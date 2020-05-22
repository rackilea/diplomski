CharacterIterator it = new StringCharacterIterator("Hello, World");
char c;

while ((c = it.next()) != CharacterIterator.DONE) {
  System.err.println("Char: " + c);
}