private static void getThreadInfo() {
    System.out.println("Started");
    ThreadMXBean managementFactory = ManagementFactory.getThreadMXBean();
    long threadIds[] = managementFactory.getAllThreadIds();
    for (int i = 0; i < threadIds.length; i++) {
        ThreadInfo info = managementFactory.getThreadInfo(threadIds[i]);
        System.out.println("Thread name = " + info.getThreadName() + " Thread id = " + info.getThreadId() + " Thread state = " + info.getThreadState());
    }

    System.out.println("#############");
    System.out.println(Thread.currentThread().getAllStackTraces());
}