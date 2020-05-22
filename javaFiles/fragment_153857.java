// Supply you input stream here
PollingRunnable pollingRunnable = new PollingRunnable(inputStream);
new Thread(pollingRunnable).start();

//To stop polling 
pollingRunnable.stopPolling();