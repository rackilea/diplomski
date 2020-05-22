public class A {

    @Autowired
    private B b;

    @Transactional
    public void doSmt() {
        try {
            someOperation(); // can throw exception
            b.logIntoDb(); // if everything is OK
        } catch {Exception e} {
            b.logIntoDbWithException(e.getMessage()); // log error into db

            throw new MyCustomException(e);
        }
    }
}

public class B{

    //outer transaction is still active
    public  void logIntoDb(String message) {
        final LogEntry logEntry = new LogEntry();
        logEntry.setDate(new Date());
        logEntry.setMessage(message);
        logEntry.persist();
    }

    // 'outer' transaction will be suspended until this method completes
    // this new transaction will commit/rollback independently of the outer transaction
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public  void logIntoDbWithException(String message) {
        final LogEntry logEntry = new LogEntry();
        logEntry.setDate(new Date());
        logEntry.setMessage(message);
        logEntry.persist();
    }
}