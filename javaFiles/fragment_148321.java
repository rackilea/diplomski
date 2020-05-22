public class RetryableAsyncExecutor {

   private final ExecutorService                       _exec;
   private final CompletionService<RetryableAsyncTest> _comp;

   public RetryableAsyncExecutor( int nThreads ) {
      _exec = Executors.newFixedThreadPool( nThreads );
      _comp = new ExecutorCompletionService<>( _exec );
   }

   public void submit( RetryableAsyncTest task ) {
      _comp.submit( task );
   }

   public RetryableAsyncTest get() throws Exception {
      final Future<RetryableAsyncTest> f = _comp.take();
      final RetryableAsyncTest task = f.get();
      if( task.isTimeouted()) {
         _comp.submit( task );
      }
      return task;
   }

   public void shutdown() {
      _exec.shutdown();
   }
}