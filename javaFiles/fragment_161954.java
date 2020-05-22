@Captor ArgumentCaptor<AsyncCallback<Foo>> captor;

@Before
public void init(){
   MockitoAnnotations.initMocks(this);
}

@Test public void shouldDoSomethingUseful() {
   //...
   verify(mock).doStuff(captor.capture());
   assertEquals("foo", captor.getValue());
}