final List<MemoryPoolMXBeans> pools = ManagementFactory.getMemoryPoolMXBeans();
for (final MemoryPoolMXBean pool : pools) {
  if (pool.getType() == MemoryType.HEAP) {
    final String name = pool.getName();
    final MemoryUsage usage = pool.getUsage();
    if (name.startsWith("Eden")) {
      System.out.println("found eden: " + usage);
    } else if (name.startsWith("Tenured")) {
      System.out.println("found tenured: " + usage);
    }
  }
}