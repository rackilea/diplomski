import java.util.function.Function;

class A {}
class B extends A {}

final public class Option<T> {
  private T value;
  public Option(T v) { value = v; }
  <U> Option<? extends U> flatMap1(Function<? super T, Option<? extends U>> mapper) {
    return mapper.apply(value);
  }

  <U> Option<? extends U> flatMap2(Function<? super T, ? extends Option<? extends U>> mapper) {
    return mapper.apply(value);
  }

  void test() {
    Option<A> oa = new Option<>(new A());
    Function<A,Option<A>> faa = (A a) -> new Option<>(new A());
    Function<A,Option<B>> fab = (A a) -> new Option<>(new B());
    //oa.flatMap1(faa);   DOES NOT COMPILE
    oa.flatMap2(fab);
  }
}