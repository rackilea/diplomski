public class HolderPatter {

  static class Bar {
    @Inject Bar(BarDependency dependency) {}
  }
  static class Baz {
    @Inject Baz(BazDependency dependency) {}
  }

  static class BarHolder {
    @Inject(optional=true) Bar value = null;
  }

  static class BazHolder {
    @Inject(optional=true) Baz value = null;
  }

  static class Foo {
    private final Bar bar;
    private final Baz baz;

    @Inject
    public Foo(BarHolder bar, BazHolder baz) {
      this.bar = bar.value;
      this.baz = baz.value;
    }
  }
}