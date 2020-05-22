//Initialized somewhere else:
ThreadMXBean bean = ...
long threadStartTime = System.currentTimeMillis();
Thread myThread = ...

//Inside your metrics-gathering code:
long now = System.currentTimeMillis();
ThreadInfo info = bean.getThreadInfo(myThread.getId());
long totalCpuTime = now - (info.getBlockedTime()+info.getWaitedTime()+threadStartTime);