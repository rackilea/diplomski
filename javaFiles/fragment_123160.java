QueuedThreadPool tp = new QueuedThreadPool(1);
// This will keep requests in queue until the current job is over
//  or client times out.
tp.setMaxQueued(connectionCount);
tp.setMaxThreads(threadCount);
tp.setMaxIdleTimeMs(maxIdle);
server.setThreadPool(tp);