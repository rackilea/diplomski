class MyTestClass {
  @Rule public MockitoRule mockitoRule = MockitoJUnit.rule(); 
  @Mock OutputData outputData;
  @Test
  void testPrintDivisionNegativePositiveRecurrentExpansion() {
    // configure mock of OutputData
    printer.print(outputData, streamOut);
    String actual = streamOut.toString();
    String expected = "_-943|225\r\n" + " -900|--------\r\n" + " ----|-4.19(1)\r\n" + " _-430\r\n" + "  -225\r\n"
        + "  ----\r\n" + " _-2050\r\n" + "  -2025\r\n" + "  -----\r\n" + "   _-250\r\n" + "    -225\r\n"
        + "    ----\r\n" + "     -25\r\n";
    assertEquals(expected, actual);
  }
}