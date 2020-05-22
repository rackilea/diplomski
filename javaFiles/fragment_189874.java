OperatingSystemMXBean osMBean = ManagementFactory.getOperatingSystemMXBean();

RuntimeMXBean runtimeMBean = ManagementFactory.getRuntimeMXBean();

System.out.println("Total physical memory:" + osMBean.getTotalPhysicalMemorySize() / 1024 + "kB");
System.out.println("Free physical memory:" + osMBean.getFreePhysicalMemorySize() / 1024 + "kB" );
System.out.println("Comm. virtual memory:" + osMBean.getProcessCpuTime() / 1024 + "kB" );
System.out.println("Total swap space:" + osMBean.getTotalSwapSpaceSize() / 1024 +" kB" );
System.out.println("Free swap space:" + osMBean.getFreeSwapSpaceSize() / 1024 +" kB" );
System.out.println("Operating system:" + osMBean.getName());
System.out.println("Arch:" + osMBean.getArch());
System.out.println("Processors:" + osMBean.getAvailableProcessors());
System.out.println("Process CPU time:" + osMBean.getProcessCpuTime() );