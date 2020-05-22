public void actionPerformed(ActionEvent e )
{


    //get values from the text fields
    double interest = Double.parseDouble(txtAnnualInterestRate.getText());

    int  year =  Integer.parseInt(txtNumberOfYears.getText());

    double loanAmount = Double.parseDouble(txtLoanAmount.getText());

    Loan loan = new Loan(interest, year, loanAmount);//see page 376 for source for loan object

    //display the monthly total payment and monthly payment
    txtMonthlyPayment.setText(String.format("%.2f", loan.getMonthlyPayment()));
    txtMonthlyPayment.setBackground(Color.YELLOW);

    txtTotalPayment.setText(String.format("%.2f", loan.getTotalPayment()));
    txtTotalPayment.setBackground(Color.YELLOW);
}//end action performed