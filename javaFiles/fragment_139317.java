class Service {
    @Transactional(propagation=Propagation.REQUIRED)
    public void doSomething() {
        // access a database using a DAO
    }
}