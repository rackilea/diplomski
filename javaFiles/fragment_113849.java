interface FillStrategy<T> {
    public void execute(List<? super T> listToFill, Contract contract);
}

class InvoiceFillStrategy implements FillStrategy<Invoice> {
    @Override
    public void execute(List<? super Invoice> listToFill, Contract contract) {
        listToFill.addAll(contract.getInvoices());
    }   
}