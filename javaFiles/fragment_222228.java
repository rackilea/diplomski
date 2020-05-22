private static void export(Scene scene) {
    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
    alert.setTitle("Export menu");
    alert.setHeaderText("Wat wilt u exporteren, adressen of ritten?");
    alert.setContentText("Maak een keuze.");
    ButtonType buttonTypeOne = new ButtonType("Adressen");
    ButtonType buttonTypeTwo = new ButtonType("Ritten");
    ButtonType buttonTypeCancel = new ButtonType("Annuleren", ButtonBar.ButtonData.CANCEL_CLOSE);
    alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo, buttonTypeCancel);
    Optional<ButtonType> result = alert.showAndWait();
    if (result.get() == buttonTypeOne){
        scene.setCursor(Cursor.WAIT);
        final Task<Void> task = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                ToCSV.export("adressen");
                return null;
            }
            @Override
            protected void succeeded() {
                scene.setCursor(Cursor.DEFAULT);
            }
        };
        new Thread(task).start();
    } else if (result.get() == buttonTypeTwo) {
        //
    } else{
        //do nothing
    }
}