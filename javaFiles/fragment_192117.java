import java.text.NumberFormat;

public class Mortgage {
  public static void main(String[] args) {
    double payment = Math.random() * 1000;
    System.out.println("Your payment is ");
    NumberFormat nf = NumberFormat.getCurrencyInstance();
    System.out.println(nf.format(payment));
  }
}