PaymentMethod payMethod = btGateway.paymentMethod().find(token);
            if(payMethod instanceof CreditCard){
                request = new TransactionRequest()
                .amount(new BigDecimal(txnAmount))
                .paymentMethodToken(token)
                .merchantAccountId("merchantAccountId")
                .serviceFeeAmount(new BigDecimal(serviceFee));
            }else{
                request = new TransactionRequest()
                .amount(new BigDecimal(txnAmount))
                .paymentMethodToken(token);
            }