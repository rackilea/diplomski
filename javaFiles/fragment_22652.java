dataColumn.setCellFactory(col -> {
    TreeTableCell<RootMaster, Integer> cell = new TreeTableCell<RootMaster, Integer>() {
        @Override
        public void updateItem(Integer item, boolean empty) {
            super.updateItem(item, empty);
            if (empty) {
                setText(null);
            } else {
                setText(item.toString());
            }
        }
    };

    cell.setAlignment(Pos.CENTER);

    return cell ;
});