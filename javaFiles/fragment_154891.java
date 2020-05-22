Result<Transaction> result = gateway.transaction().sale(
  ...
);
Transaction transaction = result.getTarget();
CreditCard creditCart = transaction.getCreditCard();
String last4 = creditCard.getLast4();
String expiration = creditCard.getExpirationDate();