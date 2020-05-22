public class DoesExpensiveProcessing implements Callable<Set<String>> {

   final Set<String> inKeys;

   public DoesExpensiveProcessing(Set<String> keys) {
     this.inKeys = keys;  // make a defensive copy if required...
   }

   public Set<String> call() {
      // do expensive processing on inKeys and returns a Set of Strings
   }
}