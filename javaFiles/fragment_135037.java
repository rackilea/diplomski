public void someEjbTransactionalMethod() {
    // will cause a rollback
    throw new XYZDirectoryException();
}

public void someOtheEjbTransactionalMethod() {
    // will NOT cause a rollback
    try {
        throw new XYZDirectoryException();
    }
    catch (XYZDirectoryException) {
        ...
    }
}