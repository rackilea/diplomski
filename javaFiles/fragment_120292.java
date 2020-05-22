public class ServiceConnectedEvent{
   private boolean isServiceConnected;

   ServiceConnectedEvent(boolean isConnected){
      this.isServiceConnected = isConnected;
   }

   public boolean isServiceConnected{
      return this.isServiceConnected;
   }
}