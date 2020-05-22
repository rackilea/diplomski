public WhateverLoop implements Runnable {
    private volatile boolean run = true;

    public void run() {
        while(run) {
            doWhatever();
        }        
    }

    public setRun(boolean run) {
        this.run = run;
    }
}