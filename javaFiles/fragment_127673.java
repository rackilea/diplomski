Runnable worker = new Runnable() {

    @Override
    public void run() {
        Runnable firstTask = getFirstTask();  // the first runnable 
        firstTask.run();

        Runnable queuedTask;
        while ( (queuedTask = getTaskFromQueue()) != null) {  // This could get blocked 
            queuedTask.run();
        }
    }
};
new Thread(worker).start();