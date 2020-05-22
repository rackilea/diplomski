List<GarbageCollectorMXBean> gcBeans = ManagementFactory.getGarbageCollectorMXBeans(); 

// generate heap state report 
String report = "";     
for (GarbageCollectorMXBean gc : gcBeans) {
    report += "\nGC Name         : " + gc.getName();
    report += "\nCollection count: " + gc.getCollectionCount();
    report += "\nCollection Time : " + gc.getCollectionTime() + " milli seconds";
    report += "\n";
}       

List<MemoryPoolMXBean> memoryPoolMXBeans = ManagementFactory.getMemoryPoolMXBeans();
for (MemoryPoolMXBean pool : memoryPoolMXBeans) {
    report += "\nMemory Pool: " + pool.getName();
    MemoryUsage usage = pool.getUsage();
    report += "\n   Max : " + usage.getMax() / 1024000 + "MB"; 
    report += "\n   Used: " + usage.getUsed() / 1024000 + "MB";
    report += "\n";
}