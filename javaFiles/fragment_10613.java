public void run() {
  while (true) {
     moveMap();
     if (!still)
        update(System.currentTimeMillis());
     try {
        Thread.sleep(13);
       // only catch the explicit exception and in localized code if possible.
     } catch (InterruptedException e) {
        e.printStackTrace();
     }
  }
}