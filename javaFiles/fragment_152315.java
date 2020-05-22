private void movePlayerOnMouseClick(Scene scene, Rectangle o, final TranslateTransition transition){
     scene.setOnMousePressed(new EventHandler<MouseEvent>() {
         @Override public void handle(MouseEvent event) {
             transition.setToX(10 * Math.cos(Math.toRadians(0)));
             transition.setToY(10 * Math.sin(Math.toRadians(0)));
             transition.playFromStart();
          }
      });
  }