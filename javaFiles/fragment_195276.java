interface Interface<T extends ArgumentInterface> {
  interface ArgumentInterface {
    // Some methods
  }

  void doCallback(Consumer<? super T> callback);
}

interface SubInterface extends Interface<ArgumentSubInterface> {
  interface ArgumentSubInterface extends ArgumentInterface {
    // Some more methods
  }

  // This is implicitly inherited
  // @Override
  // void doCallback(Consumer<? super ArgumentSubInterface> callback);
}