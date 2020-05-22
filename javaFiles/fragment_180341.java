....
    private static final String TIMER_NAME = "SOME_TIMER_NAME";
....
    @Resource
    TimerService timerService;    
....
    public void createTimer(String days, String hours, String minutes) {
        removeTimer();
        ScheduleExpression scheduleExpression = new ScheduleExpression();       
        if (days != null) {           
            scheduleExpression.dayOfMonth(datys);
        }
        if (hours != null) {           
            scheduleExpression.hour(hours);
        }
        if (minutes != null) {           
            scheduleExpression.minute(minutes);
        }
        TimerConfig timerConfig = new TimerConfig();
        timerConfig.setInfo(TIMER_NAME);
        Timer timer = timerService.createCalendarTimer(scheduleExpression, timerConfig);
    }


    private void removeTimer() {
        for (Timer timer : timerService.getTimers()) {
            if (TIMER_NAME.equals(timer.getInfo())) {
                timer.cancel();
            }
        }
    }

    @Timeout
    public void retrieveData() {
        // retrieve data from DBs
    }