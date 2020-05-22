public class Main {
   Movements shift = new Movements();
   shift.makeTurn();  // you can't call this here!

   public Main() {
      shift.makeTurn();  // but you can do it here!
   }

   public static void main(String[] args) {
      Movements shift = new Movements();       
      shift.makeTurn();  // or you can do it here!
   }
}