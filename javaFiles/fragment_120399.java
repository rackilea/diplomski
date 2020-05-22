@RestController
public class ScheduleController {

    @Autowired
    private Scheduler scheduler;

    @GetMapping(value = "/schedule/{detail}/{desc}")
    public String scheduleJob(@PathVariable(value = "detail") String detail, @PathVariable(value = "desc") String desc) throws SchedulerException {
        JobDetail job = newJob(detail, desc);
        return scheduler.scheduleJob(job, trigger(job)).toString();
    }

    private JobDetail newJob(String identity, String description) {
        return JobBuilder.newJob().ofType(SimpleJob.class).storeDurably()
                .withIdentity(JobKey.jobKey(identity))
                .withDescription(description)
                .build();
    }

    private SimpleTrigger trigger(JobDetail jobDetail) {
        return TriggerBuilder.newTrigger().forJob(jobDetail)
                .withIdentity(jobDetail.getKey().getName(), jobDetail.getKey().getGroup())
                .withSchedule(SimpleScheduleBuilder.repeatSecondlyForever(1))
                .build();
    }
}