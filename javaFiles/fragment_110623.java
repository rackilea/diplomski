import static java.util.concurrent.TimeUnit.*;
 public class PopulateTrxIdTable {
   private final ScheduledExecutorService scheduler =
     Executors.newScheduledThreadPool(1);

   public static void main(String[] args) {
     scheduler.schedule(new TrxJanitor(), 1, SECONDS);
   }
 }