private static ParameterSynchronizer<String> ps = new ParameterSynchronizer<>();

public void doSomethingSyncedByInput(String input) throws Exception {
    String lockObject = ps.getLockObject(input);
    synchronized (lockObject) {
        try {
            doSomething(input);
        } catch(Exception e) {
            throw e;
        } finally {
            ps.cleanUpLockObject(lockObject);
        }
    }
}