@Inject PerThreadManager perThreadManager;
@Inject HibernateSessionManager sessionManager; // this is a proxy to a per-thread value
@Inject Session session; // this is a proxy to a per-thread value

public void someMethod() {    
    ExecutorService executorService = ...;
    executorService.submit(new Callable() {
        public String call() {
            try {
                Monitor monitor = ...
                session.save(monitor);
                session.flush(); // optional
                sessionManager.commit();
            } catch (Exception ex) {
                sessionManager.abort();
            } finally {
                // this allows Session and HibernateSessionManager to
                // clean up after themselves
                perThreadManager.cleanup();
            }
            return ...
        }                
    });
}