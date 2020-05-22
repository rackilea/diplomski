PseudoClass ownCell = PseudoClass.getPseudoClass("own-cell");
    table.setRowFactory(param -> new TableRow<Person>() {
        protected void updateItem(Person item, boolean empty) {
            super.updateItem(item, empty);
            pseudoClassStateChanged(ownCell, item != null && item.getLName().equals("Smith"));
        };
    });