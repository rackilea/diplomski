public static int  random(int num){
    LOGGER.log(Level.INFO,"Entered Num : {0}",num);
    try {
        Thread.sleep(5);
    } catch (InterruptedException e) {
        LOGGER.log(Level.INFO,"Interrupted Exception");
    }
    return num + 2;
}