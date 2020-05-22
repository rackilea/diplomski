Set<Thread> threads = Thread.getAllStackTraces().keySet();
    boolean isWorking = threads.stream().anyMatch(t -> t.getName().equals("My backup is working"));

    if (!isWorking) {
        Runnable task = () -> {
            Thread.currentThread().setName("My backup is working");
            //some code of run backup
            System.out.println("start backup");
        };

        Thread thread = new Thread(task);
        System.out.println("Done!");
        thread.start();
    }