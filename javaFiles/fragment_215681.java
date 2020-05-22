// Suppose you have a DownloadFile class that implements Runnable
DownloadFile task1 = new DownloadFile();

...

ExecutorService exec = Executors.newSingleThreadExecutor();

Future<Boolean> future = exec.submit( task1, Boolean.TRUE );

...

// Cancel the task
future.cancel();

// Give the executor another task
DownloadFile task2 = new DownloadFile();
...
exec.submit( task2, Boolean.TRUE );