RetryTemplate retryTemplate = new RetryTemplate();

    FixedBackOffPolicy fixedBackOffPolicy = new FixedBackOffPolicy();
    fixedBackOffPolicy.setBackOffPeriod(2000l);
    retryTemplate.setBackOffPolicy(fixedBackOffPolicy);

    SimpleRetryPolicy retryPolicy = new SimpleRetryPolicy();
    retryPolicy.setMaxAttempts(5);
    retryTemplate.setRetryPolicy(retryPolicy);

    retryTemplate.execute(new RetryCallback<Void, Throwable>() {
            @Override
            public Void doWithRetry(RetryContext context) throws Throwable {
                // do some job
                if(context.getRetryCount() < 3){ // unexpected disconnection
                    log.error("connection failed");
                    throw new RuntimeException("retry exception"); 
                }
                System.out.println("RETRY" + context);
                return null;
            }
        });