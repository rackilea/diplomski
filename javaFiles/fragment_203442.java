final MemoryMXBean memBean = ManagementFactory.getMemoryMXBean();
final NotificationEmitter ne = (NotificationEmitter) memBean;

ne.addNotificationListener(listener, null, null);

final List<MemoryPoolMXBean> memPools = ManagementFactory
    .getMemoryPoolMXBeans();
for (final MemoryPoolMXBean mp : memPools) {
  if (mp.isUsageThresholdSupported()) {
    final MemoryUsage mu = mp.getUsage();
    final long max = mu.getMax();
    final long alert = (max * threshold) / 100;
    mp.setUsageThreshold(alert);

  }
}