long interval = minutes*60*1000;
    long delay = interval;

    if(prevTask != null){
        delay = System.currentTimeMillis() - prevTask.scheduledExecutionTime(); //time left of previous setting
        prevTask.cancel();
        delay = interval - delay; //difference in time left & new interval
        if(delay <=0) //if by new setting should've already ran, so run it ASAP...
            delay = 2000;

        logger.info(String.format("DB dump was already scheduled before. Set dump delay to %s minutes & setting new schedule to every %s minutes.", delay/60/1000, minutes));
    }

    TimerTask task = new TimerTask(){
        private SimpleDateFormat ft = new SimpleDateFormat("yyyy.MM.dd 'at' HH:mm:ss SSS");
        private int minutes;
        public TimerTask initialize(int minutes){
            this.minutes = minutes;
            return this;
        }
        public void run() {
            try {
                logger.info(String.format("Doing scheduled %s dump to DB. (Configured to occur every %s minutes.)", ft.format(new Date(this.scheduledExecutionTime())), minutes));
                dumpToDB();
            } catch (NamingException | SQLException e) {
                e.printStackTrace();
            }
        }
    }.initialize(minutes);

    timer.schedule(task, delay, interval);
    prevTask = task;