public void doSomething(MyQuery myQuery) {
    ...
    Transaction tx = null;
    try {
        ...
        myQuery.execute(tx);
        ...
    } catch (...) {
    } finally {
    }
}

public class MyQuery {
    public void execute(Transaction tx) {
        // run queries on transaction
    }
}