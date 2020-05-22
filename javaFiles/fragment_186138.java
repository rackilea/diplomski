@Transactional
public List<Transaction> getTransactionsForUser(User user) {
    userRepository.save(user);  // Add this <---

    List<Wallet> wallets = user.getWallets();
    List<Transaction> transactions = new ArrayList<>();

    for (Wallet wallet : wallets) {
        transactions.addAll(transactionRepository.findBySenderWallet(wallet));
    }

    return transactions;
}