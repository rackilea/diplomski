private SampleLifecycleListener sll;

public synchronized SampleLifecycleListener getSampleLifecycleListener() {
    if (sll == null) {
        sll = new SampleLifecycleListener();
    }
    return sll;
}