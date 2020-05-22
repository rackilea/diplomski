public void run(){


 long lastLoopTime = System.nanoTime();
    final int TARGET_FPS = 60;//The FPS. Can be reduced or increased.
    final long OPTIMAL_TIME = 1000000000 / TARGET_FPS;//1 second = 10^9 nanoseconds
    long lastFpsTime = 0;//Used to calculate delta
    while(running){
        long now = System.nanoTime();//Get the current time
        long updateLength = now - lastLoopTime;//get the time it took to update
        lastLoopTime = now;//set the last time the loop started to the current time
        double delta = updateLength / ((double)OPTIMAL_TIME);//Calculate delta

        lastFpsTime += updateLength;
        if(lastFpsTime >= 1000000000){
            lastFpsTime = 0;
        }

        //Right here you place your code. Update the servers, push and read data, whatever you need

        try{
            long gt = (lastLoopTime - System.nanoTime() + OPTIMAL_TIME) / 1000000;//calculate the time to sleep, and convert to milliseconds
            Thread.sleep(gt);//And finally, sleep to maintain FPS
        }catch(InterruptedException e){
        }
    }
}