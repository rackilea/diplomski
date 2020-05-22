fxSelectColumnCheckbox.setCellFactory(column -> {
        return new CheckBoxTableCell<Person, Boolean>() {
            @Override
            public void updateItem(Boolean item, boolean empty) {
                super.updateItem(item, empty);

                TableRow<Person> currentRow = getTableRow();
                this.setDisable(false); // it is required to fit default state
                if (currentRow.getItem() != null && !empty) {
                    if (currentRow.getItem().getName().equals("Peter")) {
                        this.setDisable(true);
                        setStyle(fxPersonTableView.getStyle());
                    }
                } else {

                    setStyle(fxPersonTableView.getStyle());
                }
            }
        };
    });