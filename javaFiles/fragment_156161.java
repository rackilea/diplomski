RunnableJob runnableJob = new RunnableJob();

    Thread thread1 = new Thread(runnableJob);
    thread1.setName("thread1");
    thread1.start();

    Thread thread2 = new Thread(runnableJob, "thread2");
    thread2.start();

    Thread thread3 = new Thread(runnableJob);
    thread3.start();

    Thread currentThread = Thread.currentThread();
    System.out.println("Main thread: " + currentThread.getName() + "(" +currentThread.getId() + ")");