public static class SpinnerCell<S, T extends Number> extends TableCell<S, T> {

    private Spinner<T> spinner;
    private ObservableValue<T> ov;

    public SpinnerCell() {
        this(1);
    }    

    public SpinnerCell(int step) {
        this.spinner = new Spinner<>(0, 100, step);
        setAlignment(Pos.CENTER);
    }

    @Override
    protected void updateItem(T item, boolean empty) {
        super.updateItem(item, empty);

        if (empty) {
            setText(null);
            setGraphic(null);
        } else {
            setText(null);
            setGraphic(this.spinner);

            if(this.ov instanceof Property) {
                this.spinner.getValueFactory().valueProperty().unbindBidirectional(((Property) this.ov));
            }

            this.ov = getTableColumn().getCellObservableValue(getIndex());

            if(this.ov instanceof Property) {
                this.spinner.getValueFactory().valueProperty().bindBidirectional(((Property) this.ov));
            }
        }
    }
}