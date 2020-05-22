private static ParameterSynchronizer<String> ps = new ParameterSynchronizer<>();

public void doSomethingSyncedByInput(String input){
    String lockObject = ps.getLockObject(input);
    synchronized (lockObject) {
        doSomething(input);
        ps.cleanUpLockObject(lockObject);
    }
}