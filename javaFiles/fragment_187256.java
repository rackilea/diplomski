// class MyEntityDAO extends AbstractDAO<MyEntity>
@UnitOfWork
void tryManipulateData() {
    // Due to optimistic locking, this operations cause a StaleStateException when
    // committed "by the @UnitOfWork annotation" after returning from this method.
}

// Retry mechanism, implemented wheresoever.
void manipulateData() {
    while (true) {
        try {
            retryManipulateData();
        } catch (StaleStateException e) {
            continue; // Retry.
        }
        return;
    }
}

// class MyEntityResource
@POST
// ...
// @UnitOfWork can also be used here if nested transactions are desired.
public Response someResourceMethod() {
    // Call manipulateData() somehow.
}