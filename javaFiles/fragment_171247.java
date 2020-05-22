while(isRunning){

        startTime = SystemClock.uptimeMillis();

        //update game logic, no rendering.
        update();

        //time it took to update the game state.
        loopTime = SystemClock.uptimeMillis() - startTime;

        //pausing here to make sure we update the right amount per second.
        if(loopTime < updatePeriod){
            try {
                Thread.sleep(updatePeriod-updateTime);
            } catch (InterruptedException e) {
                Log.e(TAG,"Interrupted while sleeping");
            }
        }
    }