public class VendingMachine {

   // [...]       

   public void initialise(int pd, int chrg, int stck){
      int paid = pd;
      int charge = chrg;
      int stock1; // not initialized
      int stock2 = stck;

      int result = stock1 + stock2; // will give that error

   }

}