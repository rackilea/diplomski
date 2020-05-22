interface Foo {
  void preProcess();
  void process();
  void postProcess();

  default void processAll() {
    preProcess();
    process();
    postProcess();
  }
}