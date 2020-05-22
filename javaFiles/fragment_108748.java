public class LongCalculation implements Callable<LongCalculation> {

   public double getResult() { ... }
   public SomeEnum getStatus() { ... } // e.g. FAILED, SUCCESS, CANCELLED
   public List<String> getAnythingWeirdThatHappenned() { ... }
}