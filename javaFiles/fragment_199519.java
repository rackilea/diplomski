class Test {
  void foo(Supplier<CompletionStage<Void>> bar) {
    throw new RuntimeException();
  }
  void qux() {
    foo(() -> { throw new IllegalArgumentException(); });
  }
}