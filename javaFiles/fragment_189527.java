class geniusATM {

private String name, address;
private int pin, ficoScore;
double checkingBalance, savingBalance, mortgageBalance;

public geniusATM() {

}

geniusATM(String nam, String addr, int pn, int fs, double cB, double sB, double mB) {
    name = nam;
    address = addr;
    ficoScore = fs;
    checkingBalance = cB;
    savingBalance = sB;
    mortgageBalance = mB;
}

     //setters and getters are here
    }

   class Checkings extends geniusATM {
       public Checkings() {

}
     Checkings (String nam, String addr, int pn, int fs, double cB, double sB, double mB) {super( nam, addr,  pn,  fs,cB, sB, mB);}
      }

   class Savings extends Checkings {
       public Savings() {

}
     Savings (String nam, String addr, int pn, int fs, double cB, double sB, double mB) {super( nam, addr,  pn,  fs,cB, sB, mB);}
      }


   class billPay extends Savings {
       public billPay() {

}
   billPay (String nam, String addr, int pn, int fs, double cB, double sB, 
double mB) {super( nam, addr,  pn,  fs,cB, sB, mB);}
      }


 public class singletonObject {

  private static Checkings ob;

private  singletonObject () {
    billPay matt = new billPay ("Matt", "124 Road Drive.", 1234, 3462, 560.00, 500.50, 472.29);

}

public static Checkings getObject() {
    if (ob == null) {
        ob = new billPay();
    }
    return ob;
}

public static void main(String[] args) {


}