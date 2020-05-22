if(receiptsAmountIsBetweenFactorOfXAndYOfIncome(0, 0.2))
    setTaxIncrease(getBasicTax() + 0.05 * getBasicTax());
if(receiptsAmountIsBetweenFactorOfXAndYOfIncome(0.2, 0.4))
    setTaxIncrease(getBasicTax() - 0.05 * getBasicTax());
if(receiptsAmountIsBetweenFactorOfXAndYOfIncome(0.4, 0.6))
    setTaxIncrease(getBasicTax() - 0.10 * getBasicTax());
if(receiptsAmountIsBetweenFactorOfXAndYOfIncome(0.6, 1))
    setTaxIncrease(getBasicTax() - 0.15 * getBasicTax());