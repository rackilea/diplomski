long timeDiff, sleepTime;
long afterTime, beforeTime;
long overSleepTime = 0L;

int fps = 24; // the desire FPS
long period = 1000000000L / fps;

while(true) {
  beforeTime = System.nanoTime();

  // your game logic
  update();

  afterTime = System.nanoTime();

  // timeDiff is time needed by the update process
  timeDiff = afterTime - beforeTime;
  sleepTime = (period - timeDiff) - overSleepTime;

  if(sleepTime > 0) {
    try {
      Thread.sleep(sleepTime / 1000000L); // sleeptTime is in nano secs and sleep expects millis
    } catch(InterruptedException e) {}

    // checks if the thread has slept more than desired
    overSleepTime = (System.nanoTime() - afterTime) - sleepTime;

  } else {
    // negative sleeptTime means that the system can't be update at the desired rate
    overSleepTime = 0L;
  }
}