try {
       executorService.invokeAll(tasks);
    } catch (InterruptedException e) {
        message = "interrupted";
        Thread.currentThread().interrupt();
        throw new InternalFailureException(message);
    }