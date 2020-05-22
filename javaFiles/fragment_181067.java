private void Active_BoxActionPerformed(java.awt.event.ActionEvent evt) {
    if (Active_Box.isSelected() == true) {
        Platform.runLater(() -> { // invoke "Runnable" from JFX thread
            Stage stage = new Stage();
            stage.setScene(Active.createScene());
            stage.show();
        });
    }
}