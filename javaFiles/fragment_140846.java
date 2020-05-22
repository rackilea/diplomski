@Test
public void theTest() {
    String simulatedInput = "10";
    YourClass classUnderTest = new YourClass();
    assertEquals("Thank you, now starting...", classUnderTest.getOutputFromInput(simulatedInput));
}