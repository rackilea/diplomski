final PseudoClass one = PseudoClass.getPseudoClass("one");
tableView.setRowFactory(t -> new TableRow<Model>() {

    private ChangeListener<Integer> listener = (o, oldValue, newValue) -> {
        pseudoClassStateChanged(one, newValue == 1);
    };

    @Override
    protected void updateItem(Model model, boolean empty) {
        if (getItem() != null) {
            getItem().myValueProperty().removeListener(listener);
        }

        super(model, empty);

        if (empty || model == null) {
            listener.changed(null, 0, -1);
        } else {
            model.myValueProperty().addListener(listener);
            listener.changed(null, 0, model.getMyValue());
        }
    }


});