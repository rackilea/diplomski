/**
 * start is the moment the first request is sent (in ms)
 * end is the moment, in which the targetDelta should be reached (in ms)
 * targetDelta is the targeted period between two requests (0.3)
 * initDelta is the initial delta (1.0)
 */
private int getWaitingPeriod(long start, long end, double targetDelta, double initDelta) {
    double timePassed = (double) (System.currentTimeMillis() - start);
    double progress = timePassed / (double) (end - start);
    if(progress >= 1) return (int) (targetDelta * 1000);
    return (int) ((targetDelta - (targetDelta - initDelta) * progress) * 1000);
}