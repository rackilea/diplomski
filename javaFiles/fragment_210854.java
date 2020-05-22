private static final com.sun.management.ThreadMXBean threadMXBean =
        (com.sun.management.ThreadMXBean) ManagementFactory.getThreadMXBean();

public void myAllocatingMethod() {
    long before = threadMXBean.getThreadAllocatedBytes(Thread.currentThread().getId());

    // ... some business logic that allocates memory ...
    byte[] array = new byte[500000];

    long after = threadMXBean.getThreadAllocatedBytes(Thread.currentThread().getId());
    System.out.println("Method allocated " + (after - before) + " bytes");
}