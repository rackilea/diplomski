@Transactional(propagation = Propagation.REQUIRED)
public void persistEmployee() {
    Employee employee = new Employee("Peter", "Washington DC");
    entityManager.persist(employee);
    persistLineManager();
    // Don't catch and the exception will be catched by the transaction proxy, which will rollback
}

public void persistLineManager() {
    Employee lineManager = new Employee("John", "NYC");
    entityManager.persist(lineManager);
    if(lineManager != null) // intentionally! To trigger rollback
        throw new RuntimeException("Rollback!");
}