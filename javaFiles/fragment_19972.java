@Test
public void sourceShouldThrowEventOnEventOccurrence() {
    // set up
    Mockery context = new Mockery();
    MyEventListener listener = context.mock(MyEventListener.class);
    MySource source = new MySource();
    // MyEvent event = new MyEvent(source);  <-- NO LONGER NEEDED
    source.addListener(listener);

    // set expectations
    context.checking(new Expectations() {{
        oneOf(listener).handleMyEvent(with(any(MyEvent.class)));  // <-- with any
    }});

    // execute
    // do stuff to (theoretically) raise event

    // verify
    context.assertIsSatisfied();
}