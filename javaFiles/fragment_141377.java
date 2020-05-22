public void createNoOfPurchaseUsingBatch(int noOfPurchaseInBatch) {

    BatchOperation batchOperation = new BatchOperation();

    for (int i = 1; i <= noOfPurchaseInBatch; i = i + 1) {
        Customer customer = createCustomer();
        batchOperation.addEntity(customer, OperationEnum.CREATE, "bID" + i);
    }
    try {
        this.service.executeBatch(batchOperation);
    } catch (FMSException e) {
        e.printStackTrace();
    }
}

private Customer createCustomer() {
    Customer cust = new Customer();
    cust.setDisplayName("HelloWorld " + UUID.randomUUID().toString().substring(0, 5));
    return cust;
}