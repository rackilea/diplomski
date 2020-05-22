public void startTimer() {
//set a new Timer
timer = new Timer();
//initialize the TimerTask's job --> change yourView text data
initializeTimerTask();
//schedule the timer, after the first 5000ms the TimerTask will run every 10000ms
timer.schedule(timerTask, 5000, 10000); //
}