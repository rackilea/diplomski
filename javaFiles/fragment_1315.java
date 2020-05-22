/* Share it among all threads or associate with a thread for per-thread limits
   Number of permits is to be tuned depending on acceptable load.
*/
final Semaphore queryPermits = new Semaphore(20); 


public void save(String process, int clientid, long deviceid) {
  ....
  queryPermits.acquire(); // Blocks until a permit is available

  ResultSetFuture future = session.executeAsync(bs);
  Futures.addCallback(future, new FutureCallback<ResultSet>() {
    @Override
    public void onSuccess(ResultSet result) {
      queryPermits.release();
      logger.logInfo("successfully written");
    }
    @Override
    public void onFailure(Throwable t) {
      queryPermits.release(); // Permit should be released in all cases.
      logger.logError("error= ", t);
    }
  }, executorService);
  ....
}