private volatile int globalNum;

public static int  random(int num){
    globalNum = num;
    try {
        Thread.sleep(5);
    } catch (InterruptedException e) {
        LOGGER.log(Level.INFO,"Interrupted Exception");
    }
    return globalNum + 2;
}