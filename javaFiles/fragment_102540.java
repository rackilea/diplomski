@RunWith(MockitoJUnitRunner.class)
public TestClass{

@Mock
private EventBus bus;

@Captor
private ArgumentCaptor<MyEvent> myEventCaptor;

@Test
public void testSaveAccount() {
    methodToTest();

    verify(bus).post(myEventCaptor.capture());
    MyEvent myEvent = myEventCaptor.getValue(); // last value that was captured
    assertThat(myEvent.getString, is("mystring"));
}