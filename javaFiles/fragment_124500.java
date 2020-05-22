public Future<Status> asyncSave(...) { /* should the params be ServerMessageModel? */
  return future(new Callable<Status>() {
     public Status call() {
        /* do db work here */
     }
 }