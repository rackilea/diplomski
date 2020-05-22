public int refundBalance() {
    try {
        return balance;
    } finally {
        balance = 0;
    }
}