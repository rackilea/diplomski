public Deal getDealById(Long dealId) {
   return template.get(Deal.class, dealId);
}

public class Deal {
   public BigDecimal recalculateTotalLoanAmount() {
      BigDecimal totalAmount = new BigDecimal();
      for (Loan tempLoan: deal.loanList)
         totalAmount = totalAmount + tempLoan.amount;
      setTotalAmount(totalAmount);
      return totalAmount;
   }
}