MonitoredDataImpl(Jvm vm,JmxSupport jmxSupport,JvmMXBeans jmxModel) {
    //...
    MemoryUsage mem = jmxModel.getMemoryMXBean().getHeapMemoryUsage();
    MemoryPoolMXBean permBean = jmxSupport.getPermGenPool();    
    //...
    genCapacity = new long[2];
    genUsed = new long[2];
    genMaxCapacity = new long[2];
    genCapacity[0] = mem.getCommitted();
    genUsed[0] = mem.getUsed();

    genMaxCapacity[0] = mem.getMax();

    if (permBean != null) {
        MemoryUsage perm = permBean.getUsage();
        genCapacity[1] = perm.getCommitted();
        genUsed[1] = perm.getUsed();
        genMaxCapacity[1] = perm.getMax();
    }
  }