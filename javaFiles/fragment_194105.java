listView.setCellFactory(TextFieldListCell.forListView(new StringConverter<TextModule>(){

        @Override
        public String toString(TextModule item) {
            return item.getSummary();
        }

        @Override
        public TextModule fromString(String string) {
            return new TextModule(string);
        }

    }));