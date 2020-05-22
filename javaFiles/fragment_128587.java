public class Commandment {

   private String commandment;
   private boolean read;

   public Commandment(String commandment) {
      this.commandment = commandment;
   }

   public void setRead(boolean read) {
      this.read = read;
   }

   public boolean isRead() {
      return this.read;
   }
}