@ApplicationScoped
public class TimerServiceProducer {
    @Resource
    @Produces
    TimerService timerService;
}