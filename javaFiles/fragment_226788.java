long startTime = System.nanoTime();

List<Thread> threads = new ArrayList<>();

for(int i=0;i< args.length;i++)
{

    Thread newThread = new MyThread(args[i]);
    newThread.start();
    threads.add(newThread);
}

threads.forEach(t -> {
    try {
        t.join();
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
});

long endTime = System.nanoTime();
System.out.println("Total time: " + TimeUnit.NANOSECONDS.toMillis(endTime - startTime) + " milliseconds");