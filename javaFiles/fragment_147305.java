<T> Key<Set<T>> bindMultibinder(
 Iterable<? extends TypeLiteral<? extends T>> contents, TypeLiteral<T> superClass) {
   Named annotation = randomAnnotation();
   Multibinder<T> options = 
    Multibinder.newSetBinder(binder(), superClass, annotation);
   for (TypeLiteral<? extends T> t : contents) {
      options.addBinding().to(t);
   }
   @SuppressWarnings("unchecked")
   final Key<Set<T>> multibinderKey = (Key<Set<T>>) Key.get(Types.setOf(superClass.getType()), annotation);
   return multibinderKey;
}