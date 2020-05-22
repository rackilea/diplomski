// your queue
ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();

    // create 4 Threads
    for (int i = 0; i < 4; i++) {
        new Thread(() -> {
            while (true) {
                // consume element
                concurrentLinkedQueue.poll();

                // do something with element
                // here
            }
        }).start();
    }