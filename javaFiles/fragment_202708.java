if(customerId!=null){
            PaymentMethodRequest request = new PaymentMethodRequest()
            .customerId(customerId)
            .paymentMethodNonce("paymentMethodNonceFromClient")
            .options()
                .makeDefault(true)
            .done();

            Result<PaymentMethod> result = (Result<PaymentMethod>) btGateway.paymentMethod().create(request);
            if(result.isSuccess())
                token = btGateway.customer().find(customerId).getDefaultPaymentMethod().getToken().toString();