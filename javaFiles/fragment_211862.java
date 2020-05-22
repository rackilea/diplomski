long startTime = System.currentTimeMillis();
 // do the requests
 long currentTime = System.currentTimeMillis();
 long timePassed = currentTime-startTime;
 long millisInHour = 60*60*1000;
 long timeToWait = millisInHour - timePassed;
 Thread.sleep(timeToWait);