List<EthBlock.TransactionResult> txs = web3j.ethGetBlockByNumber(DefaultBlockParameterName.LATEST, true).send().getBlock().getTransactions();
txs.forEach(tx -> {
  EthBlock.TransactionObject transaction = (EthBlock.TransactionObject) tx.get();

  System.out.println(transaction.getFrom());
});