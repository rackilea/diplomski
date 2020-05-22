int delay = 1000; //milliseconds

ActionListener taskPerformer = new ActionListener() {
    public void actionPerformed(ActionEvent evt) {
        //...Perform a task...
    }
};

Timer timer = new Timer(delay, taskPerformer);
timer.start(); //start the timer