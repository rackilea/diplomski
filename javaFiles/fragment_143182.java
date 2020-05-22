private void startTimer() {
    new Thread()
    {
        public void run()
        {
            long timeStart = new GregorianCalendar().getTimeInMillis();
            synchronized(isStopped){
                isStopped = false;
            }

            while(isTimerRunning())
            {
                long timeNow = new GregorianCalendar().getTimeInMillis() - timeStart;
                long milliseconds = (timeNow % 1000);
                timeNow = (long) Math.floor(timeNow * 0.001f);
                long seconds = (timeNow % 60);
                timeNow = (long)Math.floor((float)timeNow / 60f);
                long minutes = timeNow;

                labelTimer.setText(minutes + "." + seconds + "." + milliseconds);
            }
        }
    }.start();
}