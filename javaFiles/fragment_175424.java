DurationColumn.setCellFactory(new Callback<TableColumn<SessionItem, String>, TableCell<SessionItem, String>>() {
            @Override
            public TableCell<SessionItem, String> call(TableColumn<SessionItem, String> param) {
                return new TableCell<SessionItem, String>() {
                    @Override
                    protected void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (! isEmpty()) {
                            switch (item) {
                                case "No Duration Set":
                                    setTextFill(Color.RED); // Doesn't Work
                                    setStyle("-fx-text-fill: red") // Does Work 
                                    break;

                            }
                            setText(item);
                        }
                    }
                };
            }
        });