@Rule 
public MockitoRule mockitoRule = MockitoJUnit.rule(); 
@Mock
private IExpressionLogger expressionLogger;
@Mock
private Lookup lookup;
@Test
public void exceptionMessageLoggedAsError() {
 doThrow(new RuntimeException("UnitTest").when(lookup).getServerFDA(anyString());

  new SalesMasterModelDateSequenceWrapper(/* other parameters */,expressionLogger, lookup).getDatesClass(/* parameters */);

  verify(expressionLogger).error("the expected message containing substring 'UnitTest' from Exception");

}