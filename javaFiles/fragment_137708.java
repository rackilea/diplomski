@Subscribe
public void onPeriodChange(final Events.PeriodChangeRequestedEvent e) {
    Log.e("MAct", "Period " + e.from.toString() + " to " + e.to.toString());
    filter = new TransactionFilter() {
        @Override
        public boolean isAllowed(Transaction transaction) {
            return transaction.created.getTime() > e.from.getTime() &&
                    transaction.created.getTime() < e.to.getTime();
        }
    };

    filterTransactions();
}