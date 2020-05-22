Thread.sleep(100);
    ThreadMXBean bean = ManagementFactory.getThreadMXBean();
    long[] threadIds = bean.findDeadlockedThreads();
    for(long id: threadIds){
        System.out.println(id + " deadlocked");
    }