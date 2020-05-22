@Test
public void testTransactionBetweenCustomersAndBalanceOfReceiver() {

    int AMOUNT = 50;

    Customer customerOksana = repository.findByName("Oksana");
    Customer customerDeniss = repository.findByName("Deniss");

    transactionService.makeTransactionFromSenderToReceiver(customerDeniss, customerOksana, AMOUNT);
    assertThat(customerOksana.getBalance()).isEqualTo(customerOksana.getBalance());
}