class Object1CommonWrapper implements Common {
  Object1 delegate;

  String getName() {
    return delegate.getName();
  }
}