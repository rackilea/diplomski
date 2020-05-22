public class HelloBridge {
   private String string = "Hello";

   public void setString(String string) {
      this.string = string;
   }

   public String getString() {
      return this.string;
   }

   public void printString() {
      System.out.println(this.string);
   }
}