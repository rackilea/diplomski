for (Transaction transaction : network.getOutgoingEdges(customer)) {
  // get the other customer for this transaction
  Customer otherCustomer = network.getOpposite(customer, transaction);
  otherCustomer.setChurnProb(transaction.getWeight());
  churnedNet.add(customer);
}