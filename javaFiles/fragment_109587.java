public void scheduleTimerTask() {

        int taskStartTimeInSec = 56100;
        Timer timer = new Timer();
        Calendar today = Calendar.getInstance();
        today.set(Calendar.HOUR_OF_DAY, 0);
        today.set(Calendar.MINUTE, 0);
        today.set(Calendar.SECOND, taskStartTimeInSec);
        Date firstTime = today.getTime();
        if(firstTime.before(new Date())){
            today.add(Calendar.DATE, 1);
            firstTime = today.getTime();
        }
        System.out.println("firstTime is : "+ firstTime);
            timer.schedule(new Task(), firstTime,
                        1000*60*60*24);
    }