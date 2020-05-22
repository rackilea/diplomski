transition.setOnFinished(new EventHandler<ActionEvent>() {
          @Override public void handle(ActionEvent t) {
              o.setX(o.getX() + o.getTranslateX());
              o.setY(o.getY() + o.getTranslateY());
              o.setTranslateX(0);
              o.setTranslateY(0);
          }
     });