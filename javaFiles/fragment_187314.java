public void swap(Account a1, Account a2) {
    Account first = a1;
    Account second = a2;

    if (a1.getId().compareTo(a2.getId()) > 0) {
        first = a2;
        second = a1;
    }

    synchronized (first) {
        synchronized (second) {
            // swap the balances
        }
    }
}