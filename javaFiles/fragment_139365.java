Runtime runtime = Runtime.getRuntime();
long maxMemory = runtime.maxMemory();
long allocatedMemory = runtime.totalMemory();
long freeMemory = runtime.freeMemory();
long totalFreeMemory = freeMemory + (maxMemory - allocatedMemory);
long usedMemory = maxMemory - totalFreeMemory;