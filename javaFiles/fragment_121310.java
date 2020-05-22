public class EvictionListener implements MessageListener<String> {

   @Override
   public void onMessage(Message<String> message) {
      // Gets the local (per JVM) cache and evicts an entry from it
      Cache.getCache().evict(message.getMessageObject());
   }
}