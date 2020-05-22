public long getYoungGenAllocatedMB() {
  long youngMaxMemory;
  long youngUsedMemory;
  long youngCollectionCount;

  List<MemoryPoolMXBean> beans = ManagementFactory.getMemoryPoolMXBeans();
  for (MemoryPoolMXBean bean : beans) {
    if ("Par Eden Space".equals(bean.getName())) {
      MemoryUsage usage = bean.getUsage();
      youngMaxMemory = usage.getMax();
      youngUsedMemory = usage.getUsed();
      break;
    }
  }

  List<GarbageCollectorMXBean> gBeans = ManagementFactory.getGarbageCollectorMXBeans();
  for (GarbageCollectorMXBean bean : gBeans) {
    if ("ParNew".equals(bean.getName())) {
      youngCollectionCount = bean.getCollectionCount();
      break;
    }
  }

  return (youngCollectionCount * youngMaxMemory + youngUsedMemory) / 1024 / 1024;
}