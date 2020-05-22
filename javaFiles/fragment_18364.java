interface MyCompositeFuture extends CompositeFuture {

    // This is what the regular does, just for example
    /*
    static CompositeFuture all(List<Future> futures) {
        return CompositeFutureImpl.all(futures.toArray(new Future[futures.size()]));
    }
    */

    static <T> CompositeFuture all(List<Future<T>> futures) {
        return CompositeFutureImpl.all(futures.toArray(new Future[futures.size()]));
    }
}