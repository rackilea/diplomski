public void longRunningOperation(@Suspended AsyncResponse ar) {
 *      ar.setTimeoutHandler(customHandler);
 *      ar.setTimeout(10, TimeUnit.SECONDS);
 *      final String result = executeLongRunningOperation();
 *      ar.resume(result);
 *    }