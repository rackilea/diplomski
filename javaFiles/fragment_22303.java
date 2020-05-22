//Cancel scheduled but not started task, and avoid new ones
    myScheduler.shutdown();

    //Wait for the running tasks 
    myScheduler.awaitTermination(30, TimeUnit.SECONDS);

    //Interrupt the threads and shutdown the scheduler
    myScheduler.shutdownNow();