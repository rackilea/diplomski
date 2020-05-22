class ThreadUsageMetrics{
    long timestamp, totalBlockedTime, totalWaitTime;

    ThreadUsageMetrics(long ts, long blocked, long wait){
        timestamp = ts;
        totalBlockedTime = blocked;
        totalWaitTime = wait;
    }

    double computeCpuUsageSince(ThreadUsageMetrics prev){
        long time = timestamp - prev.timestamp;
        long blocked = totalBlockedTime - prev.totalBlockedTime;
        long waited = totalWaitTime - prev.totalWaitTime;
        return (time-(blocked+waited))/(double)time;
    }
}