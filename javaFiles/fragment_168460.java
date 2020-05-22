class Foo<T> {
   public void set(final T thing) {}
}

class Bar<T> extends Foo<T> {
   @Override
   public void set(final Object thing) {}
}