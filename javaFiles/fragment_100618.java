import org.hamcrest.Matchers;
import org.mockito.Mockito;
public void firesEventsOnDoSomething() {
  Listener listener = Mockito.mock(Listener.class);
  Doer doer = new Doer(listener);
  doer.doSomething(aaa);
  Mockito.verify(listener).onEvent(
    Mockito.argThat(
      Matchers.hasItem(
        Matchers.allOf(
          Matchers.instanceOf(EventB.class),
          Matchers.hasProperty("a", Matchers.equalTo(aaa.getA())),
          // whatever you want
        )
      )
    )
  );
}