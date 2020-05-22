@Component
class AsyncTask {

     @Async
     public Future<String> run() throws InterruptedException {
        return new AsyncResult<String>("return value");
     }
}