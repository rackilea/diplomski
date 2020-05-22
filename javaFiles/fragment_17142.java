@Override
public void start(Stage primaryStage) throws Exception {

    // You can make similar changes to loader1 if you want...

    loader2.setLocation(getClass().getResource("GameMenu.fxml"));

    GameMenuController gameMenuControl = new GameMenuController(content) ;

    gameMenuControl.doRestart.addListener(new ChangeListener<Boolean>() {
        @Override
        public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
            if(newValue) {
            scene.setRoot(startGame());
            primaryStage.setHeight(scene.getHeight());
            primaryStage.setWidth(scene.getWidth());
            gameMenuControl.doRestart.set(false);
            }
        }
    });

    loader2.setController(gameMenuControl);

    content.gameOver.addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                try {
                    scene.setRoot(loader2.load());
                    primaryStage.setHeight(180);
                    primaryStage.setWidth(240);
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

        });

    Scene scene = new Scene(startGame());
    primaryStage.setTitle("Checkers");
    primaryStage.setScene(scene);
    primaryStage.show();


}