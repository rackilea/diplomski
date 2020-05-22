<T> Key<Set<T>> bindMultibinder(
    Iterable<? extends Class<? extends T>> contents, Class<T> superClass) {
   Named annotation = randomAnnotation();
   Multibinder<T> options = 
     Multibinder.newSetBinder(binder(), superClass, annotation);
   for (Class<? extends T> t : contents) {
      options.addBinding().to(t);
   }
   @SuppressWarnings("unchecked")
   final Key<Set<T>> multibinderKey = (Key<Set<T>>) Key.get(Types.setOf( superClass ), annotation);
   return multibinderKey;
}