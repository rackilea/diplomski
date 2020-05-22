public class Main {

   public static void main( String[] args ) {
      final int COUNT = 8;
      final RetryableAsyncExecutor re = new RetryableAsyncExecutor( 5 );
      try {
         for( int i = 0; i < COUNT; ++i ) {
            re.submit( new RetryableAsyncTest("Async#"+(i+1)));
         }
         int count = 0;
         while( count < COUNT ) {
            final RetryableAsyncTest task = re.get();
            if( task.isTimeouted()) {
               System.err.printf( "%s: retrying (%d)\n",
                  task.getName(), task.getRetryCount());
            }
            else {
               System.err.printf( "%s: done with '%s'.\n",
                  task.getName(), task.getValue());
               ++count;
            }
         }
      }
      catch( final Throwable t ) {
         t.printStackTrace();
      }
      re.shutdown();
      System.exit( 0 );
   }
}