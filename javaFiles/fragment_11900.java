public void Export(ActionEvent e) {

    pg.setProgress(-1);
    Task<Void> task = new Task<Void>() {
        @Override
        protected Void call() throws Exception {
            foo();
            return null ;
        }
    };
    task.setOnSucceeded(evt -> {
        Alert alert = new Alert(AlertType.INFORMATION, "Spreadsheet Generated", ButtonType.CLOSE);
        alert.showAndWait();
        pg.setProgress(1);

    });
    new Thread(task).start();
}