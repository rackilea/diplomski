private long lastCpuTimeMillis;
private long lastPollTimeMillis;

public void checkLoadAverage() {
    long now = System.currentTimeMillis();
    long currentCpuMillis = getTotalCpuTimeMillis();
    double loadAvg = calcLoadAveragePercentage(now, currentCpuMillis);
    if (loadAvg > LOAD_AVERAGE_DUMP_THRESHOLD) {
        try {
            dumpStack("Load average percentage is " + loadAvg);
        } catch (IOException e) {
            // Oh well, we tried
        }
    }
    lastCpuTimeMillis = currentCpuMillis;
    lastPollTimeMillis = now;
}

private long getTotalCpuTimeMillis() {
    long total = 0;
    for (long id : threadMxBean.getAllThreadIds()) {
        long cpuTime = threadMxBean.getThreadCpuTime(id);
        if (cpuTime > 0) {
            total += cpuTime;
        }
    }
    // since is in nano-seconds
    long currentCpuMillis = total / 1000000;
    return currentCpuMillis;
}

private double calcLoadAveragePercentage(long now, long currentCpuMillis) {
    long timeDiff = now - lastPollTimeMillis;
    if (timeDiff == 0) {
        timeDiff = 1;
    }
    long cpuDiff = currentCpuMillis - lastCpuTimeMillis;
    double loadAvg = (double) cpuDiff / (double) timeDiff;
    return loadAvg;
}