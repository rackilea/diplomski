@RunWith(PowerMockRunner.class)
@PrepareForTest({ EventHandler.class })
public class UnderTestTest {

@Test
public void testLoadUniqueOrNull() throws NKFException {
    PowerMockito.mockStatic(EventHandler.class);

    EventHandler handler = PowerMockito.mock(EventHandler.class);
    PowerMockito.when(EventHandler.getInstance())
            .thenReturn(handler);

    ArgumentCaptor<MyObject> handlerArg = 
    ArgumentCaptor.forClass(MyObject.class);
    PowerMockito.doNothing()
            .when(handler)
            .notify(handlerArg.capture());

    new UnderTest().handleSomeEvent("test");
    Assert.assertEquals(new MyObject("test"), handlerArg.getAllValues()
            .get(0));
}

}


public class UnderTest {
    public void handleSomeEvent(String str1) {
        MyObject obj1 = new MyObject(str1);

        EventHandler.getInstance()
                .notify(obj1);
    }
}


public class MyObject {

    private final String x;

    public MyObject(String x) {
        this.x = x;
    }

    @Override
    public boolean equals(Object obj) {
        return ((MyObject) obj).x == x;
    }
}


public class EventHandler {

    private final static EventHandler e = new EventHandler();

    public static EventHandler getInstance() {
        return e;
    }

    public void notify(MyObject obj) {
        // whatever
    }
}