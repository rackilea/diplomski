TimerTask task = new TimerTask(){
    public void run()
    {
    //execute the code for every 10 mins
    }
}
timer.scheduleAtFixedRate(task, 0, 10 * 60 * 1000); // period is  10 mins