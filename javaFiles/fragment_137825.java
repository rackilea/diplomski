import java.util.*;

public class CurrencyConverter {
  public static enum Currency {
    Peso (1, "Phillipine Peso"),
    Dollar (45.17, "US Dollar"),
    Yen (0.37, "Japan Yen"),
    Pound (69.5, "UK Pound"),
    Franc (47.64, "Switzerland Franc"),
    Dinar (120.05, "Bahrain Dinar"),
    Rial (12.05, "Saudi Arabia Rial"),
    Baht (1.33, "Indonesia Baht"),
    Dirham (12.30, "UAE Dirham"),
    Yuan (7.28, "China Yuan"),
    Won (0.04, "Korea Won"),
    Euro (49.83, "Europe Euro");

    private final double rate;
    private final String fullName;

    private Currency(double rate, String fullName) {
      this.rate = rate;
      this.fullName = fullName;
    }

    public double getRate() {
      return rate;
    }

    public String getFullName() {
      return fullName;
    }
  }

  public void print() {
    System.out.println("Pick an appropriate currency: \n\n");
    for(Currency currency : Currency.values()) {
      System.out.format(" %2d - %s %n", currency.ordinal() + 1, currency.fullName);
    }
  }

  public static void main(String[] args) {

    double rate = 0;

    CurrencyConverter w = new CurrencyConverter();
    w.print();

    System.out.print("Choose the input currency: ");
    Scanner sc = new Scanner(System.in);
    int choice = sc.nextInt();

    if(choice < 1 || choice > 12) {
      System.out.println("404 not found XD");

      sc.close();

      return;
    }

    System.out.print("Choose the output currency: ");
    int output = sc.nextInt();

    Currency first = Currency.values()[choice-1];
    Currency second = Currency.values()[output-1];

    System.out.printf("Now enter the input in " + first.getFullName() + ": ");
    double input = sc.nextDouble();

    if (choice == output)
      System.out.println("Troller ._. pabobo");

    rate = (input * first.getRate()) / second.getRate();
    System.out.print("The conversion of " + first.toString() + " to "
        + second.toString() + " = " + rate);

    sc.close();
  }
}