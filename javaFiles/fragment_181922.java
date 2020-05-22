public void onClick(View view) {
    double loanAmount = Integer.parseInt(mLoanAmount.getText().toString());
    double interestRate = Double.parseDouble(mInterestRate.getText().toString());

    double baseRate = ((interestRate/100)/12);

    double rates[] = {-12*5, -12*10, -12*15, -12*20, -12*25};
    TextView views = {mMonthly5, mMonthly10, mMonthly15, mMonthly20, mMonthly25};

    for(int i=0; i<rates.length; i++) {
        double actualRate = Math.pow((1 + baseRate) , rates[i]);
        double monthlyPayment = ((loanAmount * baseRate)/(1 - actualRate));
        views[i].setText(new DecimalFormat("##.##").format(monthlyPayment));
    }
}