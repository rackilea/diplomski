Callback<TableColumn<TableData, Boolean>, TableCell<TableData, Boolean>> booleanCellFactory = 
            new Callback<TableColumn<TableData, Boolean>, TableCell<TableData, Boolean>>() {
            @Override
                public TableCell<TableData, Boolean> call(TableColumn<TableData, Boolean> p) {
                    return new BooleanCell();
            }
        };
        active.setCellValueFactory(new PropertyValueFactory<TableData,Boolean>("active"));
        active.setCellFactory(booleanCellFactory);

class BooleanCell extends TableCell<TableData, Boolean> {
        private CheckBox checkBox;
        public BooleanCell() {
            checkBox = new CheckBox();
            checkBox.setDisable(true);
            checkBox.selectedProperty().addListener(new ChangeListener<Boolean> () {
                public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                    if(isEditing())
                        commitEdit(newValue == null ? false : newValue);
                }
            });
            this.setGraphic(checkBox);
            this.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
            this.setEditable(true);
        }
        @Override
        public void startEdit() {
            super.startEdit();
            if (isEmpty()) {
                return;
            }
            checkBox.setDisable(false);
            checkBox.requestFocus();
        }
        @Override
        public void cancelEdit() {
            super.cancelEdit();
            checkBox.setDisable(true);
        }
        public void commitEdit(Boolean value) {
            super.commitEdit(value);
            checkBox.setDisable(true);
        }
        @Override
        public void updateItem(Boolean item, boolean empty) {
            super.updateItem(item, empty);
            if (!isEmpty()) {
                checkBox.setSelected(item);
            }
        }
    }