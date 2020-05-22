final PseudoClass ghosted = PseudoClass.getPseudoClass("ghosted");

billsTable.setRowFactory(row -> new TableRow<Bill>(){

    private final InvalidationListener l = o -> {
        pseudoClassStateChanged(ghosted, getItem().isSelected());
    };
    private final WeakInvalidationListener listener = new WeakInvalidationListener(l);

    @Override
    public void updateItem(Bill bill, boolean empty){
        // remove listener from last item
        Bill oldItem = getItem();
        if (oldItem != null) {
            oldItem.selectedProperty().removeListener(listener);
        }

        super.updateItem(bill, empty);

        if (bill == null || empty) {
            pseudoClassStateChanged(ghosted, false);
        } else {
            // add listener & update
            bill.selectedProperty().addListener(listener);
            l.invalidated(null);
        }
    }
});