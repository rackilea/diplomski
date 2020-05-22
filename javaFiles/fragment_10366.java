public void shiftTime(long timeToShiftInMs) {
    long targetTime = System.currentTimeMillis() + timeToShiftInMs + 10; // 10ms ahead ...
    JDKTimerService clock = getSession().getSessionClock();

    List<TimerJobInstance> jobs = new ArrayList<>();

    for (TimerJobInstance job : clock.getTimerJobInstances()) { // go through all jobs
        // He keeps already executed timer without nextFirTime
        Date nextFireTime = job.getTrigger().hasNextFireTime();
        if (nextFireTime != null) {
            long jobTime = nextFireTime.getTime();
            if (targetTime > jobTime) { // look if it should be fired after this time
                jobs.add(job);
            }
        }
    }

    for (TimerJobInstance job : jobs) {
        job.getJob().execute(job.getJobContext());
        clock.removeJob(job.getJobHandle());
    }
}