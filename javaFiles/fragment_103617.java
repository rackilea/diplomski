private long pauseEnd = 0L;

/**
 * Continue updates after a certain number of milliseconds after the current time
 */
private void pauseFor(long currentTime, long durationMillis) {
    pauseEnd = currentTime + 1_000_000L * durationMillis;
}

public void gameUpdate(long timestamp) {
    if (timestamp >= pauseEnd) { // only redraw, if not paused
        ...

        //for(int i=0;i<150000;i++) {
        //    gc.drawImage(k, current.getXlocation(), current.getYlocation());
        //    timer.stop();
        //}
        //timer.start();
        //itr.remove();
        //score++;
        gc.drawImage(k, current.getXlocation(), current.getYlocation());
        itr.remove();
        score++;
        pauseFor(timestamp, 3000); // start updates again in 3000 ms

        ...
    }
}