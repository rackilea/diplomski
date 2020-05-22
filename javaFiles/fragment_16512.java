final double[][] BRACKETS = {
    {388350.0, 0.35},
    {178650.0, 0.33},
    {85650.0, 0.28},
    {35350.0, 0.25},
    {8700.0, 0.15}
};

/* ... */

for (double[] bracket: BRACKETS) {
    if(taxableIncome > bracket[0]) {
        cumulatedTax += ((taxableIncome-bracket[0]) * bracket[1]);
        taxableIncome = (long)bracket[0];
    }
}
cumulatedTax += taxableIncome * 0.1;
taxableIncome = 0;