PublishProcessor<T> publishProcessor = PublishProcessor.create();

Map<Flowable<T>, Disposable> subscriptions = new ConcurrentHashMap<>();

void addObservable( Flowable<T> flowable ) {
  subscriptions.computeIfAbsent( flowable, fkey -> 
    flowable.subscribe( publishProcessor ) );
}
void removeObservable( Flowable<T> flowable ) {
  Disposable d = subscriptions.remove( flowable );
  if ( d != null ) {
    d.dispose();
  }
}
void close() {
  for ( Disposable d: subscriptions.values() ) {
    d.dispose();
  }
}