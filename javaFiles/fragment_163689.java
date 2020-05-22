class Account {
    private Collection<Transaction> transactions;

    public Account() {
        super();
        transactions = new ArrayList<Transaction>(4);
    }

    public Collection<Transaction> getTransactions() {
        return transactions;
    }
}