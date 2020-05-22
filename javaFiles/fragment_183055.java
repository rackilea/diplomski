public void printGCStats() {
    long totalGarbageCollections = 0;
    long garbageCollectionTime = 0;

    for(GarbageCollectorMXBean gc :
            ManagementFactory.getGarbageCollectorMXBeans()) {

        long count = gc.getCollectionCount();

        if(count >= 0) {
            totalGarbageCollections += count;
        }

        long time = gc.getCollectionTime();

        if(time >= 0) {
            garbageCollectionTime += time;
        }
    }

    System.out.println("Total Garbage Collections: "
        + totalGarbageCollections);
    System.out.println("Total Garbage Collection Time (ms): "
        + garbageCollectionTime);
}