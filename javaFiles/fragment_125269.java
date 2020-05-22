String payment_method_token = "";

TransactionRequest request = new TransactionRequest()
  .amount(new BigDecimal("100.00"));
  .paymentMethodNonce(nonceFromTheClient);
Result<Transaction> result = gateway.transaction().sale(request);
Transaction transaction = result.getTarget();

if (transaction.getPaymentInstrumentType().equals(PaymentInstrumentType.CREDIT_CARD){
  payment_method_token = transaction.getCreditCard.getToken();
}
// ... other payment method types that you support