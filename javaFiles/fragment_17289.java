Completable c = Completable.create(new CompletableOnSubscribe() {
    @Override 
    public void subscribe(@NonNull CompletableEmitter e) throws Exception {
        throw new Exception("Oh No!");
    } 
})

c.subscribe(new Action() { 
    @Override 
    public void run() throws Exception {
        Timber.v("It's ok"); 
    } 
}, new Consumer<Throwable>() {  // Second argument is onError Action
    @Override 
    public void accept(Throwable e) { 
        // Handle you exception here.
        Timber.v("Error"); 
    } 
});