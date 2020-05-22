double GiB = Math.pow(2, 30);
OperatingSystemMXBean osBean = ManagementFactory.getPlatformMXBean(OperatingSystemMXBean.class);

Double freeRamSize = (double) osBean.getFreePhysicalMemorySize();
Double totalRamSize = (double) osBean.getTotalPhysicalMemorySize();

System.out.println(freeRamSize / GiB + " / " + totalRamSize / GiB);