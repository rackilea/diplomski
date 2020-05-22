public void single() {
    double singleLimit = 32000.0; // making it double because your income is in double
    double tax1 = 0.0, tax2 = 0.0, totalTax = 0.0; // declaring all tax variables as local variables

    income = Double.parseDouble(JOptionPane.showInputDialog("Enter your income ($)"));

    if (income <= singleLimit)  {
        tax1 = rate1 * income;
    } else {
        tax1 = rate1 * singleLimit;
        tax2 = rate2 * (income - singleLimit);
    }
    double totalTax = tax1 + tax2;

    JOptionPane.showMessageDialog(null, "Taxable income for a single person wil be $" + totalTax );
}