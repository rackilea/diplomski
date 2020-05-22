public class LoanCalculator {public static void main(String[] args) {
   Scanner keyboard = new Scanner(System.in);
    BigDecimal INTEREST_RATE, currentPayment, oldPrincipal, interestPaid, principalPaid, newPrincipal, month;
    System.out.println("Enter your old Principle = ");
    oldPrincipal = keyboard.nextBigDecimal();
    System.out.println("Enter your current payment = ");
    currentPayment = keyboard.nextBigDecimal();
    NumberFormat formatter = new DecimalFormat("#0.00");
    INTEREST_RATE = new BigDecimal(7.25 / 100.0);
    formatter.format(INTEREST_RATE);//only format
    month = new BigDecimal(12);
    interestPaid = INTEREST_RATE.multiply(oldPrincipal);
    interestPaid = interestPaid.divide(month, 2);
    principalPaid = currentPayment.subtract(interestPaid);
    newPrincipal = oldPrincipal.subtract(principalPaid);
    System.out.println("Previous Balance: " + "$" + oldPrincipal);
    System.out.println("Payment: " + "$" + currentPayment);
    System.out.println("Interest Paid: " + "$" + interestPaid.setScale(2, RoundingMode.HALF_EVEN)
            + " $" + formatter.format(interestPaid));
    System.out.println("Principle Paid: " + "$" + principalPaid.setScale(2, RoundingMode.HALF_EVEN)
            + " $" + formatter.format(principalPaid));
    System.out.println("New Principal: " + "$" + newPrincipal.setScale(2, RoundingMode.HALF_EVEN)
            + " $" + formatter.format(newPrincipal));}}