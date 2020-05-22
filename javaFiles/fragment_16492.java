import javax.swing.JOptionPane;

public class InterestBanking {

    public static void main(String[] args) {

        // Banking program that asks user for the amount of money they wish to
        // invest in a
        // compound interest account (principle), the interest rate (percent
        // value) and the time frame (years).

        String principle, interestVal, years;
        float newPrinciple, newYears;

        principle = JOptionPane.showInputDialog("How much money would you like to invest?");

        interestVal = JOptionPane.showInputDialog("What's the interest rate?");

        years = JOptionPane.showInputDialog("How many years?");

        // convert from String to integer

        newPrinciple = Float.parseFloat(principle);
        newYears = Float.parseFloat(years);

        double newInterestVal = Float.parseFloat(interestVal);

        //You could change your calculation here if this isn't the need formula
        double interest = newPrinciple * Math.pow(1 + newInterestVal, newYears);

        //you were assigning the result to a total variable. That's not neccesary
        JOptionPane.showMessageDialog(null, "Interest:" + NumberFormat.getCurrencyInstance(new Locale("en", "US")).format(interest) + " In years: " + newYears);
    }
}