private static class FooFactory implements Factory<FooInterface> {

    @Override
    public void dispose(FooInterface foo) {
      // meh
    }

    @Override
    public FooInterface provide() {
      return SomeFactory.getInstance();
    }
 }