class ExpensiveInvoiceFillStrategy implements FillStrategy<Invoice> {

    private int minimumAmount;

    public ExpensiveInvoiceFillStrategy(int minimumAmount) {
        this.minimumAmount = minimumAmount;
    }

    @Override
    public void execute(List<? super Invoice> listToFill, Contract contract) {
        for (Invoice invoice : contract.getInvoices()) {
            if (invoice.getAmount() >= minimumAmount) {
                listToFill.add(invoice);
            }
        }
    }
}