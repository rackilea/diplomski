FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/foo.fxml"));
Parent root = loader.load();

MyControllerClass controller = loader.getController();

Scene mainScene = new Scene(root);
mainScene.addEventHandler(KeyEvent.KEY_PRESSED, new KeyboardEventHandler(){
        @Override
        public void handle(KeyEvent event) {
            controller.setBarcodeText("foo");
        }
});