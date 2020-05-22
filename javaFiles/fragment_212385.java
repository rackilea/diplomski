@EnableScheduling
@Configuration
public class SystemAwareSchedulerConfiguration implements SchedulingConfigurer {

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
    taskRegistrar.setScheduler(taskExecutor());
    }

    @Bean
    public ScheduledExecutorService taskExecutor() {
    ScheduledExecutorService delegateExecutor = Executors.newSingleThreadScheduledExecutor();
    SecurityContext schedulerContext = createSchedulerSecurityContext();
    return new DelegatingSecurityContextScheduledExecutorService(delegateExecutor, schedulerContext);
    }

    private SecurityContext createSchedulerSecurityContext() {
    SecurityContext securityContext = SecurityContextHolder.createEmptyContext();
    securityContext.setAuthentication(new SystemAuthentication());
    return securityContext;
    }

}