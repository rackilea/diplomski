//shared map
Map<String, Lock> locks = new ConcurrentHashMap<>(); //very important it's concurrent
...
//when a request arrives
locks.putIfAbsent(analysisId, new ReentrantLock()); //use computeIfAbsent if on Java 8
Lock lockForThisId = locks.get(analysisId);
lockForThisId.lock();
//do processing, update DB etc
lockForThisId.unlock();