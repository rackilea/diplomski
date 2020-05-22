@WebServlet(value="/QuartzTest",loadOnStartup=1)
public class QuartzInit extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public static int count=0;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuartzInit() {
        super();

        // TODO Auto-generated constructor stub
        try {

       System.out.println("TRying to start Quartz");

            JobDetail job = JobBuilder.newJob(AppCheckerJob.class)
                .withIdentity("AppCrawlerJob", "InfraStatus_Group").build();

            JobDetail job_email = JobBuilder.newJob(EmailJob.class)
                    .withIdentity("AppCrawlerEmailJob", "InfraStatus_Group").build();


            Trigger trigger = TriggerBuilder
                .newTrigger()
                .withIdentity("AppCrawlerJobTRigger", "InfraStatus_Group")
                .withSchedule(        


                                CronScheduleBuilder.cronSchedule("0 /15 * * * ?")


                ).build();

            Trigger trigger_email = TriggerBuilder
                    .newTrigger()
                    .withIdentity("AppCrawlerEmailJobTRigger", "InfraStatus_Group")
                    .withSchedule(        


                            CronScheduleBuilder.dailyAtHourAndMinute(13,16)
                    ).build();


            // schedule it
            Scheduler scheduler = new StdSchedulerFactory().getScheduler();

            scheduler.start();

            //if (sched.checkExists(job.getKey())) {sched.rescheduleJob(trigger.getKey(), trigger); } else {sched.scheduleJob(job, trigger); } 

            if(scheduler.checkExists(job.getKey())){
                System.out.println("deleting old job netry");
                scheduler.deleteJob(job.getKey());
                //scheduler.rescheduleJob(trigger.getKey(), trigger);
            }
            if(scheduler.checkExists(job_email.getKey())){
                System.out.println("deleting old email job netry");
                scheduler.deleteJob(job_email.getKey());
                //scheduler.rescheduleJob(trigger.getKey(), trigger);
            }



            scheduler.scheduleJob(job, trigger);            
            scheduler.scheduleJob(job_email, trigger_email);




        } catch (Exception se) {
            se.printStackTrace();
           throw new RuntimeException("Error while initializing quartz!!!");
        }

    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
    }

}