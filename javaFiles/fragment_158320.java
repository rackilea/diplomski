/*
        you can deal with errors using these operators:

        onErrorComplete
        onErrorResumeNext
        onErrorReturn
        onErrorReturnItem
        onExceptionResumeNext
        retry
        retryUntil
        retryWhen
         */
        return client.initiatePayment(apiRequest)
                //if in initiatePayment was error this will send cancel upstream and error downstream
                .map(initiatePaymentResponse -> { client.confirmPayment(initiatePaymentResponse.getPaymentId());})
                //if in confirmPayment was error this never happens
                .map(confirmPaymentResponse -> doConfirmationLogic(confirmPaymentResponse))
                //every error in this pipeline will trigger this one here
                .doOnError(ex -> {
                    ex.printStackTrace();
                    logError(ex);
                });