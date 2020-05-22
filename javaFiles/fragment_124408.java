ListView<File> filesList = new ListView<File>();

// Showing only the filename in the list
filesList.setCellFactory(new Callback<ListView<File>, ListCell<File>>() {
    public ListCell<File> call(ListView<File> param) {
        return new ListCell<File>() {
            @Override
            protected void updateItem(File item, boolean empty) {
                super.updateItem(item, empty);
                setText(item == null || empty ? null : item.getName());
            }
        };
    }
});

// Playing when a file is selected
filesList.getSelectionModel().selectedItemProperty().addListener((observable, oldFile, newFile) -> {
    stopPlaying(oldFile);
    play(newFile);
});