interface Fn1<A, B> {
  B apply(A a);
}

interface Functor<A, F extends Functor<?, ?>> {
  <B> F map(Fn1<A, B> f);
}