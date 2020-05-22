@Override
public void start(Stage primaryStage) {
      // ...
      Node root = ...;
      setGlobalEventHandler(root);

      Scene scene = new Scene(root, 0, 0);
      primaryStage.setScene(scene);
      primaryStage.show();
}

private void setGlobalEventHandler(Node root) {
    root.addEventHandler(KeyEvent.KEY_PRESSED, ev -> {
        if (ev.getCode() == KeyCode.ENTER) {
           okayButton.fire();
           ev.consume(); 
        }
    });
}