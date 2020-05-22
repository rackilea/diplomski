class Service {
    @Transactional(propagation=Propagation.REQUIRES_NEW)
    public void doSomething() {
        // access a database using a DAO
    }
}