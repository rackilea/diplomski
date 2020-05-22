public class DummyJob{

public DummyJob() throws ParseException, SchedulerException {

JobDetail job = new JobDetail();
job.setName("dummyJ");
job.setJobClass(NotificationCreater.class);

SimpleTrigger trigger = new SimpleTrigger();
trigger.setName("mn");
trigger.setStartTime(new Date(System.currentTimeMillis() + 1000));
trigger.setRepeatCount(SimpleTrigger.REPEAT_INDEFINITELY);
trigger.setRepeatInterval(30000);

Scheduler scheduler = new StdSchedulerFactory().getScheduler();
scheduler.start();
scheduler.scheduleJob(job, trigger);
 }
}