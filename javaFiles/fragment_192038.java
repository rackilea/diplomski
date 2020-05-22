Calendar calendar = Calendar.getInstance();
    calendar.set(Calendar.HOUR_OF_DAY, 8);
    Timer timer = new Timer();
    timer.schedule(new RemindTask(), calendar.getTime());

    class RemindTask extends TimerTask {

       public void run() {
       } 
    }