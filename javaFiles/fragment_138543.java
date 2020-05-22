public HomeLoan(double loanAmount, int loanTenure) {
    super(title);
    setLoanAmount(loanAmount)
    int homeLoanRate = 10;
    double emi = (loanAmount*loanTenure*homeLoanRate)/100; // pls change formula. This is a just a guideline
    setEMI(emi);

}