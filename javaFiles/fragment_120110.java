System.out.println(String.format("Init:\t%,d",ManagementFactory.getMemoryMXBean().getHeapMemoryUsage().getInit()));
System.out.println(String.format("Max:\t%,d%n", ManagementFactory.getMemoryMXBean().getHeapMemoryUsage().getMax()));

Thread outputThread = new Thread(() -> {
    try {
        int i = 0;
        for(;;) {
            System.out.println(String.format("%dms\t->\tUsed:\t\t%,d", i, ManagementFactory.getMemoryMXBean().getHeapMemoryUsage().getUsed()));
            System.out.println(String.format("%dms\t->\tCommited:\t%,d", i, ManagementFactory.getMemoryMXBean().getHeapMemoryUsage().getCommitted()));
            Thread.sleep(100);
            i += 100;
        }
    } catch (Exception e) { }
});

Thread allocThread = new Thread(() -> {
    try {
        int val = 0;
        Thread.sleep(500); // Wait 1/2 second
        createArray();
        Thread.sleep(500); // Wait another 1/2 seconds
        System.gc(); // Force a GC, array should be cleaned
        return;
    } catch (Exception e) { }
});

outputThread.start();
allocThread.start();