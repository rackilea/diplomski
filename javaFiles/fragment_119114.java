double[] compound = new double[arrPrincipalAmt.length];

for (int i=0; i < arrPrincipalAmt.length; i++) {
    compound[i] = arrPrincipalAmt[i] * Math.pow((1+(arrInterestRate[i]/100.0)/frequency),(frequency*time)) - arrPrincipalAmt[i];
}

return compound;