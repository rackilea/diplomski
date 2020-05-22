Stage mainAppStage = new Stage();
mainAppStage.setScene(mainScene);

PauseTransition delay = new PauseTransition(Duration.seconds(5));
delay.setOnFinished(e -> {
    primaryStage.hide();
    mainAppStage.show();
});
delay.play();

primaryStage.show();