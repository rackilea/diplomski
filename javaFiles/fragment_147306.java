<T> Key<Set<T>> bindMultibinder(Iterable<? extends Key<? extends T>> contents, Key<T> superClass) {
  Named annotation = randomAnnotation();
  Multibinder<T> options =
      Multibinder.newSetBinder(binder(), superClass.getTypeLiteral(), annotation);
  for (Key<? extends T> t : contents) {
    options.addBinding().to(t);
  }
  @SuppressWarnings("unchecked")
  final Key<Set<T>> multibinderKey =
      (Key<Set<T>>) Key.get(Types.setOf(superClass.getTypeLiteral().getType()), annotation);
  return multibinderKey;
}