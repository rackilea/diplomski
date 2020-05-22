TableColumn<FileMP3, Integer> durationCol = new TableColumn<>("Duration");
durationCol.setCellValueFactory(new PropertyValueFactory<FileMP3, Duration>("duration"));
durationCol.setCellFactory(new Callback<TableColumn<FileMP3, Duration>, TableCell<FileMP3, Duration>>() {
    @Override
    public TableCell<FileMP3, Duration> call(TableColumn<FileMP3, Duration> col) {
        return new TableCell<FileMP3, Duration>() {
            @Override
            protected void updateItem(Duration duration, boolean empty) {
                super.updateItem(duration, empty);
                if (empty) {
                    setText(null);
                } else {
                    setText(Double.toString(duration.toMillis());
                }
            }
        };
    }
});