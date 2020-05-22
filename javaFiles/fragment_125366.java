long total = 0;
    for (long id : threadMxBean.getAllThreadIds()) {
        long cpuTime = threadMxBean.getThreadCpuTime(id);
        if (cpuTime > 0) {
            total += cpuTime;
        }
    }
    // since is in nano-seconds
    long currentCpuMillis = total / 1000000;