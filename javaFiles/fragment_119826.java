class C extends A {

   private final A delegate;

   C(A obj) {
      this.delegate = obj;
   }

   Object get() { return delegate.get() }

   Object whatever() {
      return action();
   }
}