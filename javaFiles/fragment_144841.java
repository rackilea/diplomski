@Override
public void handle(Event arg0) {
  new Thread(() -> {
     for(int i=0; i<10; i++) {
       try {
          Thread.sleep(1000); // Wait for 1 sec before updating the color
       } catch (InterruptedException e) {
          e.printStackTrace();
       }
       int finalI = i;
       Platform.runLater(() -> rectangles[finalI].setFill(Color.RED));// Update on JavaFX Application Thread
   }
}).start();