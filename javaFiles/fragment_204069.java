public void exampleCPUUsageWithMXBean() {
    long previousJvmProcessCpuTime = 0;
    long previousJvmUptime = 0;
    com.sun.management.OperatingSystemMXBean prepareOperatingSystemMXBean = ManagementFactory.getPlatformMXBean(OperatingSystemMXBean.class);
    java.lang.management.OperatingSystemMXBean operatingSystemMXBean = ManagementFactory.getOperatingSystemMXBean();
    RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();

    long elapsedProcessCpuTime = prepareOperatingSystemMXBean.getProcessCpuTime() - previousJvmProcessCpuTime;
    // elapsed uptime is in milliseconds
    long elapsedJvmUptime = runtimeMXBean.getUptime() - previousJvmUptime;

    // total jvm uptime on all the available processors
    long totalElapsedJvmUptime = elapsedJvmUptime * operatingSystemMXBean.getAvailableProcessors();

    float cpuUsage = elapsedProcessCpuTime / (totalElapsedJvmUptime * 10000F);

    System.out.println(cpuUsage);

}