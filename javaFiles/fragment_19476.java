//Where you initialize the table
changingColumn.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue()));
changingColumn.setCellFactory(tc -> new TableCell<MyObject, MyObject>() {
        @Override
        public void updateItem(MyObject item, boolean empty) {
            super.updateItem(item, empty);
            if (item == null || empty) {
                setText("");
            } else if ("something".equals(item.getType())){
                setText(item.getName());
            }else {
                setText(item.getType());
            }
        }
    });