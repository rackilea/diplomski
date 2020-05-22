Label lblSecondWindow = new Label("This is the second window");
lblSecondWindow.setAlignment(Pos.TOP_LEFT);
lblSecondWindow.autosize();
lblSecondWindow.setVisible(true);
StackPane secondLayout = new StackPane();
secondLayout.getChildren().add(lblSecondWindow);
Scene secondScene = new Scene(secondLayout, 300, 200);
final Stage secondStage = new Stage();
secondStage.setTitle("Please Wait");
secondStage.setScene(secondScene);
secondStage.show();
new Thread() {
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
        } // Stands for expensive operation (the whole try catch)
        Platform.runLater(new Runnable() {

            @Override
            public void run() {
                // UI changes have to be done from the UI thread
                secondStage.close();
            }
        });
    }
}.start();