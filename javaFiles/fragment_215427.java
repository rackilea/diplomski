private Popup addExitPopup(){
    Popup exitPopup = new Popup();
    //Exit Panel
    VBox exitBox = new VBox();
    exitBox.setPadding(new Insets(10));
    Button exitPaneExit = new Button();
    exitPaneExit.setText("Return");
    exitPaneExit.setMinSize(75.0, 30.0);
    exitPaneExit.setOnAction(e -> {
        exitPopup.hide();
    });
    Button exitButton = new Button();
    exitButton.setText("Exit");
    exitButton.setMinSize(75.0, 30.0);
    exitButton.setOnAction(e -> {
        System.exit(0);
    });
    exitBox.getChildren().addAll(exitPaneExit,exitButton);
    exitBox.setVisible(true);

    exitPopup.setAutoHide(true);
    exitPopup.getContent().add(exitBox);
    return exitPopup;
}