class TestEventDispatcher implements EventDispatcher {
       public Event event;
       public EventDispatchChain tail;

       public Event dispatchEvent(Event event, EventDispatchChain tail) {
            this.event = event;
            this.tail = tail;
            return null;
       }
  }

  TestEventDispatcher testDispatcher = new TestEventDispatcher();
  MyClass testObject = new MyClass(testDispatcher);
  testObject.dosomething();
  assertThat(testDispatcher.event, someMatcher(...));