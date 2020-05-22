@Transactional
@PostMapping("/transactions")
public ResponseEntity<Transaction> createTransaction(@Valid @RequestBody Transaction transaction) {
    final Transaction storedTransaction = transactionRepository.save(transaction);
    final URI location = ServletUriComponentsBuilder.fromCurrentRequest().
            path("/{id}")
            .buildAndExpand(storedTransaction.getId()).toUri();
    Account sender = accountRepository.findById(storedTransaction.getSenderAccountId()).get();
    Account receiver = accountRepository.findById(storedTransaction.getReceiverAccountId()).get();
    Integer emitterBalance = accountRepository.findById(storedTransaction.getSenderAccountId()).get().getBalance();
    Integer receptorBalance = accountRepository.findById(storedTransaction.getReceiverAccountId()).get().getBalance();
    Integer amount = storedTransaction.getAmount();
    Integer emitterFinalBalance = emitterBalance - amount;
    Integer receptorFinalBalance = receptorBalance + amount;

    sender.setBalance(emitterFinalBalance);
    sender.getTransactionsMade().add(storedTransaction);
    accountRepository.save(sender);

    receiver.setBalance(receptorFinalBalance);
    receiver.getTransactionsReceived().add(storedTransaction);
    accountRepository.save(receiver);

    return ResponseEntity.created(location).build();
}