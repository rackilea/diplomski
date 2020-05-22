double[] factorOfIncome = {0, 0.2, 0.4, 0.6, 1};
double[] taxIncreaseFactor = {0.05, -0.05, -0.10, -0.15};

for(int i = 0; i<taxIncreaseFactor.length; i++)
    if(receiptsAmountIsBetweenFactorOfXAndYOfIncome(factorOfIncome[i], factorOfIncome[i+1]))
        increaseTaxByFactorOfX(taxIncreaseFactor[i]);