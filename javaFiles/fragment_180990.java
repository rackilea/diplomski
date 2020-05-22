class ListenerMonitor implements WhateverListenerInterface {

    private boolean gotData;
    ... some variable(s) to record the actual data

    public synchronized void onSensorChanged(...) {
        ...
        gotData=true;
        notifyAll();
    }

    public synchronized SuitableReturnType readSensor(...) throws InterruptedException {
        // register sensor event listener
        gotData = false;
        while(!gotData) wait();
        // unregister sensor event listener
        return the data?
    }   
}