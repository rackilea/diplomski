private long lastTime = 0;

 void doAction() {
     long timeNow = System.currentTimeMillis()
     if (lastTime + MIN_DELAY < timeNow) {
        return;
     }
     lastTime = timeNow;

     // Do action
 }