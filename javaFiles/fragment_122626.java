class ScoreMap<T> implements Map<T, Double> {
   private final Map<T, Double> delegate;

   ScoreMap(final Map<T, Double> delegate) {
      this.delegate = delegate;
   }

   ...

   @Override
   public Double get(final Object key) {
      // Apply custom logic, if needed
      return delegate.get(key);
   }

   // And so on...
}