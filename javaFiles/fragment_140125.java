public LoanAccount update(LoanAccount loanAccount) {
    return bank.getLoanAccounts()
            .stream()
            .filter(la -> la.getId().equals(loanAccount.getId()))
            .findFirst().orElseThrow(IllegalArgumentException::new)
            .setCreationDate(loanAccount.getCreationDate())
            .setLoanAmount(loanAccount.getLoanAmount())
            .setNumberOfInstallments(loanAccount.getNumberOfInstallments())
            .setType(loanAccount.getType());
}