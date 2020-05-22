@Test
public void printOptionWithAddedWordInDictionary() throws Exception {
  final ByteArrayInputStream inputStreamStubbed = new   ByteArrayInputStream("a|dog|super animal!".getBytes());
  InputReceiver inputReceiver = new InputReceiver(inputStreamStubbed, "\\|");
  inputReceiver.printOptions();
}