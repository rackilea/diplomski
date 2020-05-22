public class Producer {

   public void shutdown() {
      addRemainingItems();
      consumer.shutdown();
   }
}