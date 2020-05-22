class Service {
    @Transactional(propagation=Propagation.NESTED)
    public void doSomething() {
        // access a database using a DAO
    }
}