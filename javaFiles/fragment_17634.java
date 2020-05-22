public boolean showConfirmDialog(String title, String header, String content, AlertType alertType) {
    final Alert alert = new Alert(alertType);
    alert.setTitle(title);
    alert.setHeaderText(header);
    alert.setContentText(content);

    alert.getButtonTypes().clear();
    alert.getButtonTypes().addAll(ButtonType.YES, ButtonType.NO);

    //Deactivate Defaultbehavior for yes-Button:
    Button yesButton = (Button) alert.getDialogPane().lookupButton( ButtonType.YES );
    yesButton.setDefaultButton( false );

    //Activate Defaultbehavior for no-Button:
    Button noButton = (Button) alert.getDialogPane().lookupButton( ButtonType.NO );
    noButton.setDefaultButton( true );

    final Optional<ButtonType> result = alert.showAndWait();
    return result.get() == ButtonType.YES;
}