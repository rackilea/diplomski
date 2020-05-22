@Override
public void start(Stage primaryStage) throws Exception {
    Popup exitPopupO = addExitPopup();
    AnchorPane mapAnchorO = addMapAnchor();
    Scene mapScene = new Scene(mapAnchorO);
    primaryStage.setScene(mapScene);
    primaryStage.setFullScreen(true);
    primaryStage.setResizable(false);
    primaryStage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
    primaryStage.show();

    mapScene.setOnKeyPressed(e -> {
        if(e.getCode()==KeyCode.ESCAPE)
        {
            exitPopupO.show(primaryStage);
        }
    });
}