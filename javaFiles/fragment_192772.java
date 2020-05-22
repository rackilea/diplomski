int initialInvestment, endValue;
double cdValue, annualDecimalConvert, annualRate;

initialInvestment = Integer.parseInt(initialInvestmentInput.getText());
annualRate = Double.parseDouble(interestRateInput.getText())/100;
endValue = Integer.parseInt(endingValueInput.getText());

// First year interest is counted here.
cdValue = initialInvestment + (initialInvestment * annualRate);
int years = 1;

while (cdValue < endValue){
  cdValue = cdValue + (cdValue * annualRate);
  years++;
}

yearsOutput.setText("The required year needed is: " + years);