try {
                future.get(120, TimeUnit.SECONDS);
            } catch (TimeoutException e) {
                readerTimedOut = true;
                LOG.info("The Reader for the process did not complete till timeout seconds:{}", 120);
            }
int processTimeOutSeconds = 40;
            if (readerTimedOut) {
                processTimeOutSeconds = 0;
            }
            boolean isProcessTerminated = process.waitFor(processTimeOutSeconds, TimeUnit.SECONDS);