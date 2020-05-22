//do db work
synchronized(objectYouNeedToLockOn){
    //set ready flag to true (so isReady returns true)
    ready = true;
    objectYouNeedToLockOn.notifyAll();
}
//end thread run method here