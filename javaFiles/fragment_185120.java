Runnable check = new Runnable() {
    public void run() {
        checkMessage();
    }
}
Runnable send = new Runnable() {
    public void run() {
        sendMessage();
    }
}

//since what you are doing is mostly I/O you probably want to have 
//more than one thread available so that if one operation blocks,
//the other ones can be launched in parallel

ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(10);
scheduler.scheduleAtFixedRate(check, 0, 1500, MILLISECONDS);
scheduler.scheduleAtFixedRate(send, 0, 6000, MILLISECONDS);