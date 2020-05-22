public void playThread(){
    synchronized (task) {
        run = !run;
        if (run) {
            task.notify();
        }
    }
}