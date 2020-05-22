// Untested code. May need massaging.
private void closeAll(Injector injector) {
  for(Map.Entry<Key<?>, Binding<?>> entry : injector.getAllBindings().entrySet()) {
    final Binding<?> binding = entry.getValue();
    if (Closeable.class.isAssignableFrom(
        entry.getKey().getTypeLiteral().getRawType())) {
      binding.accept(new DefaultBindingScopingVisitor<Void>() {
        @Override public Void visitEagerSingleton() {
          Closeable instance = (Closeable) (binding.getProvider().get());
          try {
            instance.close();
          } catch (IOException e) {
            // log this?
          }
          return null;
        }
      });
    }
  }
}