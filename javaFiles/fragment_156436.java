public class SqsAppender extends UnsynchronizedAppenderBase<ILoggingEvent> {

    private AmazonSQSAsyncClient sqs;

    @Override
    public void start() {
        sqs = new AmazonSQSAsyncClient(
                getCredentials(),
                getClientConfiguration(),
                Executors.newFixedThreadPool(getThreadPoolSize())
        );
        super.start();
    }

    @Override
    public void stop() {
        super.stop();
        if (sqs != null) {
            AppenderExecutors.shutdown(this, sqs.getExecutorService(), getMaxFlushTime());
            sqs.shutdown();
            sqs = null;
        }
    }

    @Override
    protected void append(final ILoggingEvent eventObject) {
        SendMessageRequest request = ...
        CountDownLatch latch = new CountDownLatch(1);
        sqs.sendMessageAsync(request, new LoggingEventHandler<SendMessageRequest, SendMessageResult>(this, latch, "Error"));
        AppenderExecutors.awaitLatch(this, latch, getMaxFlushTime());
    }
}