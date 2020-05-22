show.setOnAction(new EventHandler<ActionEvent>() {
     @Override
     public void handle(ActionEvent event) {
          popup.show(primaryStage);
          Point2D point = show.localToScene(0.0,  0.0);
          popup.setX(primaryStage.getX() + point.getX());
          popup.setY(primaryStage.getY() + point.getY() + 40); 
          // this 40 could be show.getPrefHeight() if height of button is set
      }
});