public class ChainTest {

Chain chain;

@Before
public void setup() {
    chain = new Chain();
}

@Test
public void shouldReturnListOfHandlers() {

    PortInfo portInfo = Mockito.mock(PortInfo.class);
    List<Handler> handlers = chain.getHandlerChain(portInfo);
    Assert.assertNotNull(handlers);
    Assert.assertEquals(1, handlers.size());
    Assert.assertTrue(handlers.get(0) instanceOf Object);   //This should be exact assertion of whats present in index 0
}