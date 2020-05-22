class MyTestClass {
  @Rule public MockitoRule mockitoRule = MockitoJUnit.rule(); 
  @Mock OutputData outputData;
  @Test
  void testPrintDivisionNegativePositiveRecurrentExpansion() {
    List<YourElementType> inputData= Arrays.asList(new YourElementType(dummyValues1), new YourElementType(dummyValues2), new YourElementType(dummyValues3)); 
    doReturn(inputData).when(outputData).getValuesToPrint();
    printer.print(outputData, streamOut);
    // ...