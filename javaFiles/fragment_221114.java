import java.text.*;

public class Currency {

   private double TotalPrice;

   // only one instance required
   NumberFormat   nformat = NumberFormat.getCurrencyInstance();

   public static void main(String[] args) {
      new Currency().start();
   }

   public void start() {
      final double nightlyRate = 100.00;

      int elapse = 1020202220; // random value
      double elapsedDays = elapse / (24 * 60 * 60 * 1000.);
      TotalPrice = elapsedDays * nightlyRate;
      String formattedCurrency = formatCurrency(TotalPrice);
      System.out.println(formattedCurrency);
   }

   public String formatCurrency(double amount) {
      String fmtedCurrency = nformat.format(amount);
      return fmtedCurrency;
   }

}