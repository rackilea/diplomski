try {
     if (Thread.currentThread().isInterrupted()) {
            break;
     }
     TimeUnit.SECONDS.sleep(1);
}

       ...

// rest of the code