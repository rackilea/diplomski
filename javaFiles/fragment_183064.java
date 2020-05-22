class IModule extends AbstractModule {
  @Override public void configure() {
    MapBinder<Integer, I> myBinder =
        MapBinder.newMapBinder(binder(), Integer.class, I.class);
    myBinder.addBinding(1).to(A.class);
    // Add more here.
  }
}

// You can even split the MapBinding across Modules, if you'd like.
class SomeOtherModule extends AbstractModule {
  @Override public void configure() {
    // MapBinder.newMapBinder does not complain about duplicate bindings
    // as long as the keys are different.
    MapBinder<Integer, I> myBinder =
        MapBinder.newMapBinder(binder(), Integer.class, I.class);
    myBinder.addBinding(3).to(C.class);
    myBinder.addBinding(4).to(D.class);
  }
}