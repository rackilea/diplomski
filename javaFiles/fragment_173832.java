listView.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {
        @Override 
        public ListCell<String> call(ListView<String> param) {
            return new ListCell<String>() {
                @Override 
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if ("Orange".equals(item)) {
                        setDisable(true);
                    } else {
                        setDisable(false);
                    }
                    setText(item);
                }

            };
        }
    });