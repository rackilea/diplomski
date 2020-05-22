for (String loanId : loanIds) {    
 int loanIdInt = Integer.parseInt(loanId) - 1;
 Long bankId = Long.parseLong(funderIds[loanIdInt]);
 Long loanIdLong = (long) loanIdInt + 1;
 Long purpose = Long.parseLong(purposes[loanIdInt]);
 loanFinance.setFundingBankId(bankId);
 loanFinance.setIdFundsProductPurpose(purpose);
 loanFinance.setLoanId(loanIdLong);
 loanFinance.setLastModifiedBy(user.getId());
 loanFinance.setIdEntityloan(loanIdLong);
 loanFinance.setAmount(10000.00);
 loanFinance.setStatus("A");
 commonRepository.save(loanFinance);    
}