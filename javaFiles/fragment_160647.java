private static void addCustomerTransaction() {
  customerInput((bank, branchName, customerName, transaction) ->
      bank.addCustomerTransaction(branchName, customerName, transaction));
}

private static void addCustomer() {
  customerInput((bank, branchName, customerName, transaction) ->
      bank.addCustomer(branchName, customerName, transaction));
}