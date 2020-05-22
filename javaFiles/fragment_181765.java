@Test
public void testTransactionBetweenCustomersAndBalanceOfReceiver() {

    int AMOUNT = 50;

    // prepare your test data unless you always expect those values to exist.
    Customer customerReceiver = new Customer();
    customerReciever.setName("Oksana");
    customerReceiver.setBalance(12);
    customerReceiver = repository.save(customerReceiver);

    Customer customerSender = new Customer();
    customerSender.setName("Deniss");
    customerSender.setBalance(5);
    customerSender = repository.save(customerSender);

    // assign before executing method
    int expectedReceiverAmount = customerReceiver.getBalance() + AMOUNT;
    int expectedSenderAmount = customerSender.getBalance() - AMOUNT;
    transactionService.makeTransactionFromSenderToReceiver(customerSender, customerReceiver, AMOUNT);

    assertEquals(expectedSenderAmount, customerSender.getBalance());
    assertEquals(expectedReceiverAmount, customerReceiver.getBalance());
}