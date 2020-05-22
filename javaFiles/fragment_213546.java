class MyService {
    // Have a field of type TransactionTemplate
    private TransactionTemplate template;

    // In the constructor, Spring will inject the correct bean
    public MyService(PlatformTransactionManager transactionManager) {
        template = new TransactionTemplate(transactionManager);
        // Set this here if you always want this behaviour for your programmatic transaction
        template.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
    }

    // Here you start your first transaction when arriving from the outside
    @Transactional(propagation = Propagation.REQUIRED)
    public void persistEmployee() {
        Employee employee = new Employee("Peter", "Washington DC");
        entityManager.persist(employee);
        // Inner call
        try {
            persistLineManager();
        } catch (RuntimeException e) {
            // Do what you want
        }
    }

    public void persistLineManager() {
        // Here, ask to your transactionTemplate to execute your code.
        template.execute(status -> {
            Employee lineManager = new Employee("John", "NYC");
            entityManager.persist(lineManager);
            if(lineManager != null) // intentionally! To trigger rollback
                throw new RuntimeException("Rollback!");
            return null;
        });
    }
}