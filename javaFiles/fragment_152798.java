public class Event<A> implements Functor<A, Event<?>> {

  public final A value;

  public Event(A _value) {
    value = _value;
  }

  public <B> Event<B> map(Fn1<A, B> f) {
    return new Event<B>(f.apply(value));
  }

  public String toString() {
    return "Event<" + value.getClass().getSimpleName() + ">(" + value.toString() + ")";
  }
}