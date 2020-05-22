List<Account> accountsWithMinimum = new ArrayList<>();
for (Account acccount : accounts.values() ) {
    if (account.balance > threshold) {
        accountsWithMinimum.add(account);
    }
}