Map<String, Future<Resource>> map = new ConcurrentHashMap<String, Future<Resource>>();    
...
Future<Resource> r = map.get(name);
if (r == null) {
    FutureTask task = null;
    synchronized (lock) {
        r = map.get(name);
        if (r == null) {
            task = new FutureTask(new Callable<Resource>() {
                public Resource call() {
                    return veryCostlyOperation(name);
                }
            });
            r = task;
            map.put(name, r);
        }
    }
    if (task != null) task.run(); // Retrieve the resource
}

return r.get(); // Wait while other thread is retrieving the resource if necessary