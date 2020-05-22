public static void awaitLatch(Appender<?> appender, CountDownLatch latch, long waitMillis) {
    if (latch.getCount() > 0) {
        try {
            boolean completed = latch.await(waitMillis, TimeUnit.MILLISECONDS);
            if (!completed) {
                appender.addWarn(format("Appender '%s' did not complete sending event in %d milliseconds, " +
                                        "the event might have been lost",
                                        appender.getName(), waitMillis));
            }
        } catch (InterruptedException ex) {
            appender.addWarn(format("Appender '%s' was interrupted, " +
                                    "a logging event might have been lost or shutdown was initiated",
                                    appender.getName()));
            Thread.currentThread().interrupt();
        }
    }
}