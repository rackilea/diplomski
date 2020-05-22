tc.setCellFactory(column -> {
        return new TableCell<TableListObject, String>() {
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);

                if (item == null || empty) {
                    setText(null);
                    setStyle("");
                } else {
                    if (item.equals("Something")) {
                        setStyle("-fx-background-color: blue");
                    } else {
                        setStyle("");
                    }
                }
            }
        };
    });