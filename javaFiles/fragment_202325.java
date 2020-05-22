public class Exchanger<V> {
   ...
   private static final int NCPU = Runtime.getRuntime().availableProcessors();
   ....
   /**
    * The number of times to spin (doing nothing except polling a
    * memory location) before blocking or giving up while waiting to
    * be fulfilled.  Should be zero on uniprocessors.  On
    * multiprocessors, this value should be large enough so that two
    * threads exchanging items as fast as possible block only when
    * one of them is stalled (due to GC or preemption), but not much
    * longer, to avoid wasting CPU resources.  Seen differently, this
    * value is a little over half the number of cycles of an average
    * context switch time on most systems.  The value here is
    * approximately the average of those across a range of tested
    * systems.
    */
   private static final int SPINS = (NCPU == 1) ? 0 : 2000;