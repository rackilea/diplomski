public class FunctorDemo {

  interface Fn1<A, B> {
    B apply(A a);
  }

  interface Functor<A, F extends Functor<?, ?>> {
    <B> F map(Fn1<A, B> f);
  }

  static class ObservableFunctor {
    public static <A,B> Observable<B> map(Observable<A> fa, Fn1<A, B> f) {
      return new Observable<B>(f.apply(fa.value));
    }
  }

  static class Observable<A>  {

    public final A value;

    public Observable(A _value) {
      value = _value;
    }

    public String toString() {
      return "Observable<" + value.getClass().getSimpleName() + ">(" + value.toString() + ")";
    }
  }

  static class Event<A> implements Functor<A, Event<?>> {

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

  public static void main(String[] args) {

    Observable<Event<Long>> oe1 = new Observable(new Event(42L));
    System.out.println("oe1: " + oe1.toString()); // oe1: Observable<Event>(Event<Long>(42))

    Observable<Event<String>> oe2 = ObservableFunctor.map(oe1,
      new Fn1<Event<Long>, Event<String>>() {
        public Event<String> apply(Event<Long> e) {
          return e.map(
            new Fn1<Long, String>() {
              public String apply(Long l) {
                return l.toString();
              }
            }
          );
        }
      }
    );
    System.out.println("oe2: " + oe2.toString()); // oe2: Observable<Event>(Event<String>(42))

  }
}