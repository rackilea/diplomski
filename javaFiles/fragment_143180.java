private void stopTimer(){
    synchronized(isStopped){
        isStopped = true;
    }
}

private boolean isTimerRunning(){
    boolean result = false;
    synchronized(isStopped){
        result = !isStopped;
    }
    return result;
}