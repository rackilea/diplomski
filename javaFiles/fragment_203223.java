class A {
  private double balance;// Don't use static
  public A(double balance) {// You will need this
      this.balance = balance;
  }
  public double getBalance() { return balance; }
}
class B extends A {
  public B(double balance) { 
      super(balance);//Important
  }
  public void d() { System.out.println(getBalance()); }
}
public class Main {
  public static void main(String args[]) {
    B b = new B(100.0);
    b.d();
  }
}