public class CronJob {

    public static void main(String[] args) throws ParseException, SchedulerException {

        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

        JobDetail job = newJob(TestJob.class)
            .withIdentity("cronJob", "testJob") 
            .build();

        String startDateStr = "2013-09-27 00:00:00.0";
        String endDateStr = "2013-09-31 00:00:00.0";

        Date startDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").parse(startDateStr);
        Date endDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").parse(endDateStr);

        CronTrigger cronTrigger = newTrigger()
          .withIdentity("trigger1", "testJob")
          .startAt(startDate)
          .withSchedule(CronScheduleBuilder.cronSchedule("0 0 9-12 * * ?").withMisfireHandlingInstructionDoNothing())
          .endAt(endDate)
          .build();

        scheduler.scheduleJob(job, cronTrigger);
        scheduler.start();
    }    

    public static class TestJob implements Job {
        @Override
        public void execute(JobExecutionContext context) throws JobExecutionException {
            System.out.println("this is a cron scheduled test job");
        }        
    }
}