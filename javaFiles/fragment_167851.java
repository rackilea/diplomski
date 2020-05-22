Timer randomTimer = new Timer();
 randomTimer.schedule(new TimerTask() {
     @Override
     public void run() {
           // do your stuff including the next
           int size = Shapes.size();
           Platform.runLater(() -> {
               MyPane.getChildren().add(Shapes.get(size));
          });
     }
}, 0, 1000);