@Slf4j
@Service
@ConditionalOnProperty(prefix = "schedule", name = {"job.one"}, havingValue = "true")
public class JobOneScheduler {

    @Scheduled(cron = "*/2 * * * * *")
    public void runJob() {
        log.debug( "Running job one... {}", LocalDateTime.now() );
    }
}


@Slf4j
@Service
@ConditionalOnProperty(prefix = "schedule", name = {"job.two"}, havingValue = "true")
public class JobTwoScheduler {
    @Scheduled(cron = "*/5 * * * * *")
    public void runJob() {
        log.debug( "Running job two... {}", LocalDateTime.now() );
    }
}