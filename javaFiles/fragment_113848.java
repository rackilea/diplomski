private <E> void fillListForName(String name, List<? super E> listToFill, FillStrategy<E> fillStrategy) {
    if (name == null) {
        throw new IllegalArgumentException("name cannot be null");
    }
    for (SupplierAccount account : listContracts) {
        if (name.equals(account.getSupplier())) {
            List<Contract> contracts = account.getContracts();
            for (Contract contract : contracts) {
                fillStrategy.execute(listToFill, contract);
            }
        }
    }
}