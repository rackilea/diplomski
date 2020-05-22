class CallbackImpl<V, U> implements Callback<TreeTableColumn<V, U>, TreeTableCell<V, U>>
{

    private final ObservableList<U> paymentData;

    public CallbackImpl(ObservableList<U> paymentData) {
        this.paymentData = paymentData;
    }

    @Override
    public TreeTableCell<V, U> call(TreeTableColumn<V, U> tc) {
        ComboBox<U> combo = new ComboBox<>();
        combo.getItems().addAll(paymentData);
        JFXTreeTableCell<V, U> cell = new JFXTreeTableCell<V, U>() {
            @Override
            protected void updateItem(U payment, boolean empty) {
                super.updateItem(payment, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    combo.setValue(payment);
                    setGraphic(combo);
                }
            }
        };
        return cell ;
    }
}