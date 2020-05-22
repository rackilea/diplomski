//do some work
synchronized(objectYouNeedToLockOn){
    while (!dbThread.isReady()){
        objectYouNeedToLockOn.wait();
    }
}
//continue with work after dbThread is ready