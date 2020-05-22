public void oneOfButtonsShouldHaveText() {
  // Given
  List<JButton> buttons = testSubject.getButtons();
  // You don't have to get the list of buttons from the tested class, you could
  // create a list of buttons within the test.
  String text = "I was chosen";

  // When
  testSubject.printTextOnRandomButton(buttons);

  // Then
  assertTrue(button1.getText().equals(text) || button2.getText().equals(text) || button3.getText().equals(text));
}