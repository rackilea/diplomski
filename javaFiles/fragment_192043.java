final Retryer<DescribeResourceResult> deleteResourceRetryer = RetryerBuilder
            .<DescribeResourceResult>newBuilder()
            .retryIfResult(Predicates.notNull())
            .withWaitStrategy(WaitStrategies.fixedWait(500, TimeUnit.MILLISECONDS))
            .withStopStrategy(new OnResourceNotFoundExceptionStopStrategy())
            .build();