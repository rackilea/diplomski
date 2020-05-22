@Service
public class QuartzExecutor {


    private JobEntityDao jobEntityDao;

    @Autowired 
    public QuartzExecutor(JobEntityDao jobEntityDao) throws ParseException, SchedulerException {
        this.jobEntityDao = jobEntityDao; 
        init();
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    private void init() throws ParseException, SchedulerException {
        List<JobEntity> jobEntities = jobEntityDao.findAll();

        for (JobEntity jobEntity : jobEntities) {
            System.out.println(jobEntity.cronExpression);

            RunMeTask task = new RunMeTask();

            //specify your sceduler task details
            JobDetail job = new JobDetail();
            job.setName("runMeJob");
            job.setJobClass(RunMeJob.class);

            Map dataMap = job.getJobDataMap();
            dataMap.put("runMeTask", task);

            //configure the scheduler time
            CronTrigger trigger = new CronTrigger();
            trigger.setName("runMeJobTesting");
            trigger.setCronExpression(jobEntity.cronExpression);

            //schedule it
            Scheduler scheduler = new StdSchedulerFactory().getScheduler();
            scheduler.start();
            scheduler.scheduleJob(job, trigger);
        }
    }

}