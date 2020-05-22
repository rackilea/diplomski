public static <T> T getApplicationService(Class<T> type) {
    // applicationServices needs to be a ConcurrentHashMap otherwise 
    // the following containsKey can conflict with the subsequent put
    if(!applicationServices.containsKey(type)) {
        // need to synchronize before modifying the map
        synchronized(applicationServices) {
            // check if another thread created the same service while 
            // we were waiting for the lock
            if(!applicationServices.containsKey(type)) {
                T newService = ServiceLoader.create(type);
                applicationServices.put(type, newService);
            }
        }
    }
    return (T) applicationServices.get(type);
}