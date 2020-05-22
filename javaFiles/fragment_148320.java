public class RetryableAsyncTest implements Callable<RetryableAsyncTest> {

   private final String  _name;
   private /* */ String  _value;
   private /* */ boolean _timeouted;
   private /* */ int     _retryCount;

   public RetryableAsyncTest( String name ) {
      _name = name;
   }

   @Override
   public RetryableAsyncTest call() throws Exception {
      try {
         ++_retryCount;
         _timeouted = false;
         //-------- Begin of functionnal code
         if( Math.random() > 0.5 ) {      // Simulation of
            throw new TimeoutException(); // timeout condition
         }
         _value = "computation result";
         //-------- End of functionnal code
      }
      catch( final TimeoutException x ) {
         _timeouted = true;
      }
      return this;
   }

   public String getName() {
      return _name;
   }

   public String getValue() {
      return _value;
   }

   public boolean isTimeouted() {
      return _timeouted;
   }

   public int getRetryCount() {
      return _retryCount;
   }
}